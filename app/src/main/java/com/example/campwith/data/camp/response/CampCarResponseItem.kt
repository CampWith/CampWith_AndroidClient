package com.example.campwith.data.camp.response

import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class CampCarResponseItem(
    val __v: Int,
    val _id: String,
    val price: String,
    val title: String,
    val url: String,
    val image: String
) : Parcelable