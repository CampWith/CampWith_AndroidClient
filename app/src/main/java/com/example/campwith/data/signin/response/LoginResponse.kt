package com.example.campwith.data.signin.response

data class LoginResponse(
    val result: Result
) {
    data class Result(
        val token: String,
        val uid: String,
        val message: String
    )
}