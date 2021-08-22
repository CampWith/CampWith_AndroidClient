package com.example.campwith.remote

import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.camptool.response.CampToolResponse
import com.example.campwith.data.login.request.LoginRequest
import com.example.campwith.data.login.response.LoginResponse
import com.example.campwith.remote.NetworkHelper.api
import io.reactivex.Single

class RemoteDataSourceImpl : RemoteDataSource {
    override fun signIn(
        body: LoginRequest
    ) = api.signIn(body)

    override fun getRecommendCamp() = api.getRecommendCamp()

    override fun getCamp(
        doNm: String
    ) = api.getCamp(doNm)

    override fun getTypeCamp(
        type: Int
    ) = api.getTypeCamp(type)

    override fun getCampDetail(
        id: String
    ) = api.getCampDetail(id)

    override fun getCampCar(): Single<CampCarResponse> = api.getCampCar()

    override fun getCampTool(): Single<CampToolResponse> = api.getCampTool()
}