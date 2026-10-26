package org.ucb.mobile3p.exchange.domain.usecase

import kotlin.time.Clock
import org.ucb.mobile3p.exchange.domain.repository.ExchangeRepository

class SaveEventUseCase(
    val repository: ExchangeRepository
) {
    suspend fun invoke(type: String) {
        repository.saveEvent(type, Clock.System.now().toEpochMilliseconds())
    }
}
