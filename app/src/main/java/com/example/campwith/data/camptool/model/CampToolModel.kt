package com.example.campwith.data.camptool.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class CampToolModel(
    val img: String,
    val info: String,
    val title: String,
    var isFront: Boolean
) : Parcelable