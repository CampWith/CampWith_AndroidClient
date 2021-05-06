package com.example.campwith.remote

import com.example.campwith.data.camp.CampResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("api/campsites/list/{doNm}")
    fun getCamp(
        @Path("doNm") serviceKey: String
    ) : Single<CampResponse>
}