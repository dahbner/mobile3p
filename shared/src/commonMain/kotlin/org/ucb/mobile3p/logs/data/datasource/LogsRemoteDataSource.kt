package org.ucb.mobile3p.logs.data.datasource

import com.develoop.logs.LogRequest
import com.develoop.logs.LogResponse
import org.ucb.mobile3p.log.LogService

class LogsRemoteDataSource(
    private val service: LogService
) {
    suspend fun send(request: LogRequest): LogResponse {
        return service.sendLogs(request)
    }
}
