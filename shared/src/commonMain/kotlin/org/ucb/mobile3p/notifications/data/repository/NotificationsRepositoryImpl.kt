package org.ucb.mobile3p.notifications.data.repository

import org.ucb.mobile3p.notifications.data.datasource.MessagingDataSource
import org.ucb.mobile3p.notifications.domain.repository.NotificationsRepository

class NotificationsRepositoryImpl(
    val messagingDataSource: MessagingDataSource
) : NotificationsRepository {
    override suspend fun getToken(): String {
        return messagingDataSource.getToken()
    }
}
