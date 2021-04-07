package com.example.campwith.remote

import com.example.campwith.data.CampResponse
import io.reactivex.Single

interface RemoteDataSource {
    fun getCamp(
        serviceKey: String,
        mobileOS: String,
        mobileApp: String,
        type: String,
        pageNo: Int,
        numOfRows: Int
    ) : Single<CampResponse>
}