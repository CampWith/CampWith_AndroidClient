package com.example.campwith.data.review

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val name: String,
    val date: String,
    val score: String,
    val text: String
): Parcelable