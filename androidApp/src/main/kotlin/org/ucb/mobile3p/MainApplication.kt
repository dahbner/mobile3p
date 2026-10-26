package org.ucb.mobile3p

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import org.ucb.mobile3p.di.initKoinAndroid
import org.ucb.mobile3p.scheduler.LogScheduler

class MainApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
        createNotificationChannel()

        val logScheduler = LogScheduler(this)
        logScheduler.schedulePeriodicalUpload()
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
