package com.example.campwith.remote

import com.example.campwith.data.camp.response.CampCarResponse
import com.example.campwith.data.camp.response.CampToolResponse
import com.example.campwith.remote.NetworkHelper.api
import io.reactivex.Single

class RemoteDataSourceImpl : RemoteDataSource {
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