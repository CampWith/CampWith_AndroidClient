package com.example.campwith.data.camptool.response

data class CampToolResponse(
    val success: Boolean,
    val status: Int,
    val result: Result
) {
    data class Result(
        val campingtoolList: List<CampToolResponseItem>
    )
}