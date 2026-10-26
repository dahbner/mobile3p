package org.ucb.mobile3p

import android.app.Application
import org.ucb.mobile3p.di.initKoinAndroid

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
    }
}
