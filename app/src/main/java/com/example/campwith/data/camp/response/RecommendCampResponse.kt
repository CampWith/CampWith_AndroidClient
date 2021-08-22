package com.example.campwith.data.camp.response

data class RecommendCampResponse(
    val result: List<CampResponseItem>,
    val status: Int,
    val success: Boolean
)