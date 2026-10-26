package org.ucb.mobile3p.exchange.domain.repository

import kotlinx.coroutines.flow.Flow

interface ExchangeRepository {
    suspend fun observe(): Flow<String?>
    suspend fun saveEvent(type: String, timestamp: Long)
}
