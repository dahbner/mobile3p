package org.ucb.mobile3p.notification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

actual class LocalNotification actual constructor(
    context: Any?
) {
    private val androidContext = context as? Context
        ?: throw IllegalArgumentException("Context must be an instance of android.content.Context")

    actual fun show(title: String, message: String) {
        val builder = NotificationCompat.Builder(androidContext, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
        androidContext.getSystemService(NotificationManager::class.java)
            .notify(System.currentTimeMillis().toInt(), builder.build())
    }

    companion object {
        const val CHANNEL_ID = "general"
    }
}
