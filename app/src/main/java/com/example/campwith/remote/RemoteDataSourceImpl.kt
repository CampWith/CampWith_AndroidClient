package com.example.campwith.remote

import com.example.campwith.remote.NetworkHelper.api

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getCamp(
        doNm: String
    ) = api.getCamp(doNm)
}