package com.example.campwith.data.review.response

import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class ReviewResponseItem(
    val comment: String,
    val rating: Float,
    val time: String,
    val user: String,
    val uid: Int
) : Parcelable