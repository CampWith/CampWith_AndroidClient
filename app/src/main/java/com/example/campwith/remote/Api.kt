package com.example.campwith.remote

import com.example.campwith.data.camp.response.RecommendCampResponse
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.data.camptool.response.CampToolResponse
import com.example.campwith.data.login.request.LoginRequest
import com.example.campwith.data.login.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("/api/users/signIn")
    fun signIn(@Body body: LoginRequest): Single<LoginResponse>

    @GET("/api/campsites/recommend")
    fun getRecommendCamp(): Single<RecommendCampResponse>

    @GET("api/campsites/list/{doNm}")
    fun getCamp(
        @Path("doNm") doNm: String
    ): Single<CampResponse>

    @GET("api/campsites/category/{type}")
    fun getTypeCamp(
        @Path("type") type: Int
    ): Single<CampResponse>

    @GET("api/campsites/detail/{id}")
    fun getCampDetail(
        @Path("id") id: String
    ): Single<CampDetailResponse>

    @GET("api/campingcar/list")
    fun getCampCar(): Single<CampCarResponse>

    @GET("api/campingtool/list")
    fun getCampTool(): Single<CampToolResponse>
}