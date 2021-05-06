package com.example.campwith.remote

import com.example.campwith.data.camp.CampResponse
import io.reactivex.Single

interface RemoteDataSource {
    fun getCamp(
        doNm: String
    ) : Single<CampResponse>
}