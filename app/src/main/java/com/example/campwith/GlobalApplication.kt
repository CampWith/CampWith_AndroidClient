package com.example.campwith

import android.app.Application
import com.example.campwith.di.myDiModule
import com.naver.maps.map.NaverMapSdk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("acdbyskku1")

        KakaoSdk.init(this, getString(R.string.kakao_app_key))

        startKoin {
            androidLogger()
            androidContext(this@GlobalApplication)
            modules(myDiModule)
        }
    }
}