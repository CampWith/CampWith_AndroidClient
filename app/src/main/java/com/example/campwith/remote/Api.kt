package com.example.campwith.remote

import com.example.campwith.data.bookmark.request.BookmarkRequest
import com.example.campwith.data.bookmark.response.BookmarkCampResponse
import com.example.campwith.data.bookmark.response.BookmarkResponse
import com.example.campwith.data.camp.response.RecommendCampResponse
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.data.camptool.response.CampToolResponse
import com.example.campwith.data.common.response.CommonResponse
import com.example.campwith.data.review.request.AddReviewBody
import com.example.campwith.data.review.request.DeleteReviewBody
import com.example.campwith.data.review.request.ModifyReviewBody
import com.example.campwith.data.review.response.AddReviewResponse
import com.example.campwith.data.review.response.CommonReviewResponse
import com.example.campwith.data.signin.request.SignInRequest
import com.example.campwith.data.signin.response.LoginResponse
import com.example.campwith.data.signup.request.SignUpRequest
import io.reactivex.Single
import retrofit2.http.*

interface Api {
    @POST("/api/users/signIn")
    fun signIn(@Body body: SignInRequest): Single<LoginResponse>

    @POST("/api/users/signUp")
    fun signUp(@Body body: SignUpRequest): Single<LoginResponse>

    @GET("/api/campsites/recommend")
    fun getRecommendCamp(): Single<RecommendCampResponse>

    @GET("api/campsites/list/{doNm}")
    fun getCamp(
        @Path("doNm") doNm: String
    ): Single<CampResponse>

    @GET("api/campsites/category/{type}")
    fun getTypeCamp(
        @Path("type") type: Int
    ): Single<CampResponse>

    @GET("api/campsites/detail/{id}")
    fun getCampDetail(
        @Path("id") id: String
    ): Single<CampDetailResponse>

    @GET("/api/users/favorites")
    fun getBookmarkCamp(): Single<BookmarkCampResponse>

    @POST("/api/users/favorites")
    fun addBookmark(@Body body: BookmarkRequest): Single<CommonResponse>

    @PUT("/api/users/favorites")
    fun deleteBookmark(@Body body: BookmarkRequest): Single<BookmarkResponse>

    @POST("/api/reviews/add")
    fun addReview(@Body body: AddReviewBody): Single<AddReviewResponse>

    @PUT("/api/reviews/modify")
    fun modifyReview(@Body body: ModifyReviewBody): Single<CommonReviewResponse>

    @HTTP(method = "DELETE", path = "/api/reviews/delete", hasBody = true)
    fun deleteReview(@Body body: DeleteReviewBody): Single<CommonReviewResponse>

    @GET("api/campingcar/list")
    fun getCampCar(): Single<CampCarResponse>

    @GET("api/campingtool/list")
    fun getCampTool(): Single<CampToolResponse>
}