package org.ucb.mobile3p.logs.domain.usecase

import org.ucb.mobile3p.logs.domain.model.LogModel
import org.ucb.mobile3p.logs.domain.repository.LogsRepository

class SendLogUseCase(
    val repository: LogsRepository
) {
    suspend fun invoke(log: LogModel): Boolean {
        return repository.send(log)
    }
}
