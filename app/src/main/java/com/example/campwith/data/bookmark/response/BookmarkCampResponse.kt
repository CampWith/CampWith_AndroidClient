package com.example.campwith.data.bookmark.response

import com.example.campwith.data.camp.response.CampResponseItem

data class BookmarkCampResponse(
    val result: Result
) {
    data class Result(
        val favorites: List<CampResponseItem>,
    )
}