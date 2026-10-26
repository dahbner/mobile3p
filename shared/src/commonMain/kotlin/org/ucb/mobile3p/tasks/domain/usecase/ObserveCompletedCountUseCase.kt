package org.ucb.mobile3p.tasks.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

class ObserveCompletedCountUseCase(
    private val repository: TasksRepository
) {
    fun invoke(): Flow<Long> {
        return repository.observeCompletedCount()
    }
}