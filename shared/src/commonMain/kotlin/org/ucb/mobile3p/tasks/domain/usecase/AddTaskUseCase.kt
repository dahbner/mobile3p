package org.ucb.mobile3p.tasks.domain.usecase

import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

class AddTaskUseCase(
    private val repository: TasksRepository
) {
    suspend fun invoke(title: String) {
        repository.addTask(title)
    }
}