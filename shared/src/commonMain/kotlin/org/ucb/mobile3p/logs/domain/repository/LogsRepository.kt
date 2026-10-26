package org.ucb.mobile3p.logs.domain.repository

import org.ucb.mobile3p.logs.domain.model.LogModel

interface LogsRepository {
    suspend fun send(log: LogModel): Boolean
}
