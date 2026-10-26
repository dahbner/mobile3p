package org.ucb.mobile3p.log

import com.develoop.logs.LogRequest
import com.develoop.logs.LogResponse

actual class LogService actual constructor(
    serverUrl: String
) {
    actual suspend fun sendLogs(request: LogRequest): LogResponse {
        error("gRPC no implementado en iOS")
    }
}
