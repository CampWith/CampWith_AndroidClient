package com.example.campwith.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val addr1: String,
    val doNm: String,
    val facltNm: String,
    val mapX: Double,
    val mapY: Double
): Parcelable