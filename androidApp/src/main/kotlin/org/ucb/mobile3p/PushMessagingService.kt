package org.ucb.mobile3p

import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.PendingIntent
import android.content.Intent
class PushMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        println("FCM nuevo token = $token")
    }

    // Solo se llama con la app abierta: en segundo plano la notificación la muestra Firebase
    override fun onMessageReceived(message: RemoteMessage) {
        val notification = message.notification ?: return

        val messageId = message.data["message_id"] ?: message.messageId ?: "sin-id"

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("message_id", messageId)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(notification.title)
            .setContentText(notification.body)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        getSystemService(NotificationManager::class.java)
            .notify(System.currentTimeMillis().toInt(), builder.build())
    }

    companion object {
        const val CHANNEL_ID = "general"
    }
}
