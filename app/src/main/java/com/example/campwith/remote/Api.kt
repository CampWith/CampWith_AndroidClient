package com.example.campwith.remote

import com.example.campwith.data.CampResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("basedList")
    fun getCamp(
        @Query("ServiceKey") serviceKey: String,
        @Query("MobileOS") mobileOS: String,
        @Query("MobileApp") mobileApp: String,
        @Query("_type") type: String,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int
    ) : Single<CampResponse>
}