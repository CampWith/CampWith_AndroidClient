package com.example.campwith.data.review.request

data class AddReviewBody(
    var campsiteId: String,
    var comment: String,
    var rating: Float
)