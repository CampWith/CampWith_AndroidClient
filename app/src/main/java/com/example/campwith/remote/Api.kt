package com.example.campwith.remote

import com.example.campwith.data.camp.response.CampCarResponse
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.camp.response.CampResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("api/campsites/list/{doNm}")
    fun getCamp(
        @Path("doNm") serviceKey: String
    ): Single<CampResponse>

    @GET("api/campsites/detail/{id}")
    fun getCampDetail(
        @Path("id") id: String
    ): Single<CampDetailResponse>

    @GET("api/campingcar/list")
    fun getCampCar(): Single<CampCarResponse>
}