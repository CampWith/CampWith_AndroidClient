package com.example.campwith

import android.app.Application
import com.example.campwith.di.myDiModule
import com.naver.maps.map.NaverMapSdk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("acdbyskku1")

        startKoin {
            androidLogger()
            androidContext(this@GlobalApplication)
            modules(myDiModule)
        }
    }
}