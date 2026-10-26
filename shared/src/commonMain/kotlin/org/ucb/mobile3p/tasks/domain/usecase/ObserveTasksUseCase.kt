package org.ucb.mobile3p.tasks.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.tasks.domain.model.TaskModel
import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

class ObserveTasksUseCase(
    private val repository: TasksRepository
) {
    fun invoke(): Flow<List<TaskModel>> {
        return repository.observeTasks()
    }
}