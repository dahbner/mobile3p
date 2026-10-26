package org.ucb.mobile3p.exchange.data.repository

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.exchange.data.datasource.RealTimeDataBase
import org.ucb.mobile3p.exchange.data.dto.EventDto
import org.ucb.mobile3p.exchange.domain.repository.ExchangeRepository

class ExchangeRepositoryImpl(
    val realTimeDataBase: RealTimeDataBase
): ExchangeRepository {
    override suspend fun observe(): Flow<String?> {
       return realTimeDataBase.observeMessage()
    }

    override suspend fun saveEvent(type: String, timestamp: Long) {
        realTimeDataBase.saveEvent(EventDto(type = type, timestamp = timestamp))
    }
}
