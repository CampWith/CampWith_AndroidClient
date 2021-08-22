package com.example.campwith.remote

import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.data.camptool.response.CampToolResponse
import io.reactivex.Single

interface RemoteDataSource {
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