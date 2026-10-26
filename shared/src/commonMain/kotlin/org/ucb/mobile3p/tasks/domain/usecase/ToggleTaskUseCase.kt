package org.ucb.mobile3p.tasks.domain.usecase

import org.ucb.mobile3p.tasks.domain.model.TaskModel
import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

class ToggleTaskUseCase(
    private val repository: TasksRepository
) {
    suspend fun invoke(
        task: TaskModel,
        completed: Boolean
    ) {
        repository.setTaskCompleted(task, completed)
    }
}