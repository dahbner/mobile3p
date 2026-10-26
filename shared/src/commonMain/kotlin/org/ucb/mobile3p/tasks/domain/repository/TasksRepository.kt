package org.ucb.mobile3p.tasks.domain.repository

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.tasks.domain.model.TaskModel

interface TasksRepository {
    fun observeTasks(): Flow<List<TaskModel>>

    fun observeCompletedCount(): Flow<Long>

    suspend fun addTask(title: String)

    suspend fun setTaskCompleted(
        task: TaskModel,
        completed: Boolean
    )
}