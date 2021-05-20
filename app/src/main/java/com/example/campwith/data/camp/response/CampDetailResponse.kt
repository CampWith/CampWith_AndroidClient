package com.example.campwith.data.camp.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CampDetailResponse(
    val _id: String,
    val addr1: String,
    val doNm: String,
    val facltNm: String,
    val firstImageUrl: String,
    val mapX: Double,
    val mapY: Double,
    val sigunguNm: String,
    val tel: String
) : Parcelable