package org.ucb.mobile3p.notifications.domain.usecase

import org.ucb.mobile3p.notifications.domain.repository.NotificationsRepository

class GetFcmTokenUseCase(
    val repository: NotificationsRepository
) {
    suspend fun invoke(): String {
        return repository.getToken()
    }
}
