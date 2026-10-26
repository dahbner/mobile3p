package org.ucb.mobile3p.tasks.data.datasource

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.database
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import org.ucb.mobile3p.tasks.data.dto.TaskDto
import org.ucb.mobile3p.tasks.domain.model.TaskModel

class TasksFirebaseDataSource {
    private val firestore by lazy { Firebase.firestore }
    private val realTimeDataBase by lazy { Firebase.database }

    private val tasksRef by lazy { firestore.collection("tareas") }
    private val completedCountRef by lazy { realTimeDataBase.reference("stats/completadas") }

    fun observeTasks(): Flow<List<TaskModel>> {
        return tasksRef.snapshots.map { snapshot ->
            snapshot.documents
                .map { document ->
                    document.data<TaskDto>().toModel(document.id)
                }
                .sortedBy { task -> task.title.lowercase() }
        }
    }

    fun observeCompletedCount(): Flow<Long> {
        return completedCountRef.valueEvents
            .map { snapshot ->
                snapshot.value<Long?>() ?: 0L
            }
            .distinctUntilChanged()
    }

    suspend fun addTask(title: String) {
        val cleanTitle = title.trim()

        require(cleanTitle.isNotEmpty()) {
            "No se permite titulo vacio"
        }

        tasksRef.add(
            TaskDto(
                title = cleanTitle,
                completed = false
            )
        )
    }

    suspend fun setTaskCompleted(
        task: TaskModel,
        newCompleted: Boolean
    ) {
        if (task.completed == newCompleted) return

        val documentRef = tasksRef.document(task.id)
        val difference = if (newCompleted) 1L else -1L

        try {
            documentRef.updateFields {
                "completed" to newCompleted
            }
        } catch (firestoreError: Exception) {
            println(
                "Firestore falló. RTDB no será modificado: " +
                        firestoreError.message
            )
            throw firestoreError
        }

        try {
            completedCountRef.runTransaction(
                Long.serializer().nullable
            ) { currentValue ->
                val current = currentValue ?: 0L
                (current + difference).coerceAtLeast(0L)
            }
        } catch (databaseError: Exception) {
            println(
                "RTDB fallo. Se intentará revertir Firestore: " +
                        databaseError.message
            )

            val rollbackResult = runCatching {
                documentRef.updateFields {
                    "completed" to task.completed
                }
            }

            rollbackResult.exceptionOrNull()?.let { rollbackError ->
                println(
                    "Tambien fallo rollback de Firestore: " +
                            rollbackError.message
                )

                throw IllegalStateException(
                    "No se pudo sincronizar ni revertir la operacion",
                    rollbackError
                )
            }

            println("Rollback completado")
            throw databaseError
        }
    }


}