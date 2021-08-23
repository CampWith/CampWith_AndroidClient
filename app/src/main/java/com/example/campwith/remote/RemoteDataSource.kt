package com.example.campwith.remote

import com.example.campwith.data.camp.response.RecommendCampResponse
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.data.camptool.response.CampToolResponse
import com.example.campwith.data.signin.request.SignInRequest
import com.example.campwith.data.signin.response.LoginResponse
import com.example.campwith.data.signup.request.SignUpRequest
import io.reactivex.Single

interface RemoteDataSource {
    fun signIn(
        body: SignInRequest
    ): Single<LoginResponse>

    fun signUp(
        body: SignUpRequest
    ): Single<LoginResponse>

    fun getRecommendCamp(): Single<RecommendCampResponse>

    fun getCamp(
        doNm: String
    ): Single<CampResponse>

    fun getTypeCamp(
        type: Int
    ): Single<CampResponse>

    fun getCampDetail(
        id: String
    ): Single<CampDetailResponse>

    fun getCampCar(): Single<CampCarResponse>

    fun getCampTool(): Single<CampToolResponse>
}