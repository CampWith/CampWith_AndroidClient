package com.example.campwith.remote

import android.util.Log
import com.example.campwith.User
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkHelper {
    private const val BASE_URL = "http://13.209.43.90:8080/"

    private val okHttpClent = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
        })
        .addInterceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("x-auth-token", User.token)
                .build()
            Log.d("okhttp", it.request().toString())
            val response = it.proceed(request)
            response
        }.build()

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClent)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api: Api = retrofit.create(Api::class.java)
}