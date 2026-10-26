package org.ucb.mobile3p.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import org.ucb.mobile3p.shared.R

actual class LocalNotification actual constructor(
    context: Any?
) {
    private val androidContext = context as? Context
        ?: throw IllegalArgumentException("Context must be an instance of android.content.Context")

    actual fun show(title: String, message: String) {
        val openAppIntent = androidContext.packageManager.getLaunchIntentForPackage(androidContext.packageName)
        val pendingIntent = PendingIntent.getActivity(androidContext, 0, openAppIntent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(androidContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        androidContext.getSystemService(NotificationManager::class.java)
            .notify(System.currentTimeMillis().toInt(), builder.build())
    }

    companion object {
        const val CHANNEL_ID = "general"
    }
}
