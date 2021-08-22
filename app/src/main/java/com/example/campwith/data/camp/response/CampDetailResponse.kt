package com.example.campwith.data.camp.response

import com.example.campwith.data.review.response.ReviewResponseItem

data class CampDetailResponse(
    val success: Boolean,
    val status: Int,
    val result: Result,
) {
    data class Result(
        val campsite: CampResponseItem,
        val reviews: List<ReviewResponseItem>
    )
}