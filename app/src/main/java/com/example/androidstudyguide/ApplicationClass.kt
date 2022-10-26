package com.example.androidstudyguide

import android.app.Application
import com.example.androidstudyguide.di.dataModule
import com.example.androidstudyguide.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationClass)
            modules(dataModule, viewModelModule)
        }
    }
}
