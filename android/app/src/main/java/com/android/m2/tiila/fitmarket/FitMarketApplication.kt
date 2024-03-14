package com.android.m2.tiila.fitmarket

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FitMarketApplication : Application() {

    companion object {
        var instance: FitMarketApplication? = null
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        startKoin {
            androidContext(this@FitMarketApplication)
            modules(appModule)
            modules(commonModule)
        }
    }
}