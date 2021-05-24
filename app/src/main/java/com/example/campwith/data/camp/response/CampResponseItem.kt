package com.example.campwith.data.camp.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CampResponseItem(
    val _id: String,
    val addr1: String,
    val doNm: String,
    val facltNm: String,
    val firstImageUrl: String,
    val category: Int,
    val mean_rate: Float
) : Parcelable