package org.ucb.mobile3p.notifications.presentation.viewmodel

data class NotificationsState(
    val isLoading: Boolean = true,
    val token: String? = null,
    val error: String? = null
)
