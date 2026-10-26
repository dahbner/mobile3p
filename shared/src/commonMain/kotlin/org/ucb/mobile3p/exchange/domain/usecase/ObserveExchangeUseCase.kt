package org.ucb.mobile3p.exchange.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.exchange.domain.repository.ExchangeRepository

class ObserveExchangeUseCase(
    val repository: ExchangeRepository
) {
    suspend fun invoke(): Flow<String?> {
        return repository.observe()
    }
}
