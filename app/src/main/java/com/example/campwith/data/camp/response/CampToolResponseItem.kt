package com.example.campwith.data.camp.response


import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class CampToolResponseItem(
    val _id: String,
    val img: String,
    val info: String,
    val title: String
) : Parcelable