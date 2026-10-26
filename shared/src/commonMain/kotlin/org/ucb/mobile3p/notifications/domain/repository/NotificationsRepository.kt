package org.ucb.mobile3p.notifications.domain.repository

interface NotificationsRepository {
    suspend fun getToken(): String
}
