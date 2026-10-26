package org.ucb.mobile3p.log

expect class LogService(serverUrl: String) {
    suspend fun sendLogs(
        request: com.develoop.logs.LogRequest
    ): com.develoop.logs.LogResponse
}
