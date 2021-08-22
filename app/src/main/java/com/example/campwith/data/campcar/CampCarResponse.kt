package com.example.campwith.data.campcar

data class CampCarResponse(
    val success: Boolean,
    val status: Int,
    val result: Result
) {
    data class Result(
        val campingCarList: List<CampCarResponseItem>
    )
}