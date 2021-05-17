package com.example.campwith.remote

import com.example.campwith.data.camp.CampCarResponse
import com.example.campwith.data.camp.CampDetailResponse
import com.example.campwith.data.camp.CampResponse
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