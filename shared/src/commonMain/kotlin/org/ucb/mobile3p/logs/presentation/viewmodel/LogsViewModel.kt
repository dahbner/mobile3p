package org.ucb.mobile3p.logs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.time.Clock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ucb.mobile3p.logs.domain.model.LogLevelModel
import org.ucb.mobile3p.logs.domain.model.LogModel
import org.ucb.mobile3p.logs.domain.usecase.SendLogUseCase

class LogsViewModel(
    val usecase: SendLogUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LogsState())
    val state = _state.asStateFlow()

    fun sendTestLog() {
        viewModelScope.launch {
            _state.value = LogsState(isSending = true)
            val log = LogModel(
                level = LogLevelModel.ERROR,
                message = "Something went wrong",
                stackTrace = "Stacktrace here...",
                androidId = "abc123",
                appInstanceId = "instance_001",
                versionCode = 123,
                userId = "user_42",
                mobileTimeStamp = Clock.System.now().toEpochMilliseconds()
            )
            _state.value = runCatching { usecase.invoke(log) }.fold(
                onSuccess = { ok -> LogsState(result = if (ok) "LOG_RESULT_OK" else "LOG_RESULT_ERROR") },
                onFailure = {
                    println("gRPC logs error: ${it.message}")
                    LogsState(error = it.message ?: "Error al enviar el log")
                }
            )
        }
    }
}
