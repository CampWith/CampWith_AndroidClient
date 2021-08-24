package com.example.campwith.data.review.request

data class ModifyReviewBody(
    var review: String,
    var comment: String,
    var rating: Float
)