package org.ucb.mobile3p.log

import com.develoop.logs.LogRequest
import com.develoop.logs.LogResponse
import com.develoop.logs.LogServiceClient
import com.squareup.wire.GrpcClient
import okhttp3.OkHttpClient
import okhttp3.Protocol

actual class LogService actual constructor(
    serverUrl: String
) {
    private val httpClient = OkHttpClient.Builder()
        .protocols(listOf(Protocol.H2_PRIOR_KNOWLEDGE))
        .build()

    private val grpcClient = GrpcClient.Builder()
        .client(httpClient)
        .baseUrl(serverUrl)
        .build()

    private val logService =
        grpcClient.create(LogServiceClient::class)

    actual suspend fun sendLogs(
        request: LogRequest
    ): LogResponse {
        return logService.send().execute(request)
    }
}
