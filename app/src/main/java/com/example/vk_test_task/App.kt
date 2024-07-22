package com.example.vk_test_task

import android.app.Application
import com.example.vk_test_task.di.dataModule
import com.example.vk_test_task.di.domainModule
import com.example.vk_test_task.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, viewModelModule)
        }
    }
}