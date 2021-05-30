package com.example.campwith.data.camp.response

import android.annotation.SuppressLint
import android.os.Parcelable
import com.example.campwith.data.review.response.ReviewResponseItem
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class CampDetailResponse(
    val _id: String,
    val addr1: String,
    val category: Int,
    val doNm: String,
    val facltNm: String,
    val firstImageUrl: String,
    val homepage: String,
    val lineIntro: String,
    val mapX: Double,
    val mapY: Double,
    val mean_rate: Float,
    val reviews: List<ReviewResponseItem>,
    val sigunguNm: String,
    val tel: String
) : Parcelable