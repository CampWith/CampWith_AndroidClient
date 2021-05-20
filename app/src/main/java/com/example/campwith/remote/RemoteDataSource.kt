package com.example.campwith.remote

import com.example.campwith.data.camp.response.CampCarResponse
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.camp.response.CampResponse
import io.reactivex.Single

interface RemoteDataSource {
    fun getCamp(
        doNm: String
    ): Single<CampResponse>

    fun getCampDetail(
        id: String
    ): Single<CampDetailResponse>

    fun getCampCar(): Single<CampCarResponse>
}