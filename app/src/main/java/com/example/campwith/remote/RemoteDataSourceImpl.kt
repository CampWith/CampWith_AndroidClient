package com.example.campwith.remote

import com.example.campwith.data.CampResponse
import com.example.campwith.remote.NetworkHelper.api
import io.reactivex.Single

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getCamp(
        serviceKey: String,
        mobileOS: String,
        mobileApp: String,
        type: String,
        pageNo: Int,
        numOfRows: Int
    ) = api.getCamp(serviceKey, mobileOS, mobileApp, type, pageNo, numOfRows)
}