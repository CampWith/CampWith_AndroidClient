package com.example.campwith.data.bookmark.response

data class BookmarkResponse(
    val result: Result
) {
    data class Result(
        val nickname: String
    )
}