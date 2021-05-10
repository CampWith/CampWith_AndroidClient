package com.example.campwith.data.camp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CampItem(
    val _id: String,
    val addr1: String,
    val doNm: String,
    val facltNm: String,
    val firstImageUrl: String
): Parcelable