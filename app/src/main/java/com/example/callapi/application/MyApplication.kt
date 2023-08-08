package com.example.callapi.application

import android.app.Application
import com.example.callapi.data.repo.lstAPIModule
import com.example.callapi.di.networkModule
import com.example.callapi.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(viewModelModule, networkModule, lstAPIModule))
        }
    }
}