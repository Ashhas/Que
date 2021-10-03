package com.example.que

import android.app.Application
import com.example.que.di.databaseModule
import com.example.que.di.networkModule
import com.example.que.di.repositoryModule
import com.example.que.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class QueApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@QueApplication)
            modules(networkModule, viewModelModule, repositoryModule, databaseModule)
        }
    }
}