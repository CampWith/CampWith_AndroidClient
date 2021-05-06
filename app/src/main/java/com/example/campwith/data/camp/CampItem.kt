package com.example.campwith.data.camp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CampItem(
    val addr1: String,
    val doNm: String,
    val facltNm: String,
    val mapX: Double,
    val mapY: Double,
    val firstImageUrl: String
): Parcelable