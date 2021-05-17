package com.example.campwith.remote

import com.example.campwith.data.camp.CampCarResponse
import com.example.campwith.data.camp.CampResponse
import com.example.campwith.remote.NetworkHelper.api
import io.reactivex.Single

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getCamp(
        doNm: String
    ) = api.getCamp(doNm)

    override fun getCampDetail(
        id: String
    ) = api.getCampDetail(id)

    override fun getCampCar(): Single<CampCarResponse> = api.getCampCar()
}