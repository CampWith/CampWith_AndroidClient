package com.example.campwith.data.camp.response

data class CampResponse(
    val success: Boolean,
    val status: Int,
    val result: Result
) {
    data class Result(
        val campsiteList: List<CampResponseItem>,
    )
}