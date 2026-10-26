package org.ucb.mobile3p.tasks.data.repository

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.tasks.data.datasource.TasksFirebaseDataSource
import org.ucb.mobile3p.tasks.domain.model.TaskModel
import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

class TasksRepositoryImpl(
    private val dataSource: TasksFirebaseDataSource
) : TasksRepository {

    override fun observeTasks(): Flow<List<TaskModel>> {
        return dataSource.observeTasks()
    }

    override fun observeCompletedCount(): Flow<Long> {
        return dataSource.observeCompletedCount()
    }

    override suspend fun addTask(title: String) {
        dataSource.addTask(title)
    }

    override suspend fun setTaskCompleted(
        task: TaskModel,
        completed: Boolean
    ) {
        dataSource.setTaskCompleted(task, completed)
    }
}