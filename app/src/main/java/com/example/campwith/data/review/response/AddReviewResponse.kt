package com.example.campwith.data.review.response

data class AddReviewResponse(
    val result: Result,
    val status: Int,
    val success: Boolean
) {
    data class Result(
        val reviewId: String
    )
}