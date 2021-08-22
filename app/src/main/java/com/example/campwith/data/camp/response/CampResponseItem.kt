package com.example.campwith.data.camp.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CampResponseItem(
    val _id: String,
    val addr1: String,
    val category: Int,
    val doNm: String,
    val facltNm: String,
    val firstImageUrl: String,
    val mapX: Double,
    val mapY: Double,
    val meanRate: Float,
    val sigunguNm: String,
    val tel: String
) : Parcelable