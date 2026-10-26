package org.ucb.mobile3p

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import org.ucb.mobile3p.di.initKoinAndroid

class MainApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "general",
            "General",
            NotificationManager.IMPORTANCE_HIGH
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }
}
