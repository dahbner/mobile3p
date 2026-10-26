package org.ucb.mobile3p.logs.presentation.viewmodel

data class LogsState(
    val isSending: Boolean = false,
    val result: String? = null,
    val error: String? = null
)
