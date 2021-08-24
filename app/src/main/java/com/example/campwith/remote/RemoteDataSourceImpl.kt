package com.example.campwith.remote

import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.camptool.response.CampToolResponse
import com.example.campwith.data.review.request.AddReviewBody
import com.example.campwith.data.review.request.DeleteReviewBody
import com.example.campwith.data.review.request.ModifyReviewBody
import com.example.campwith.data.signin.request.SignInRequest
import com.example.campwith.data.signup.request.SignUpRequest
import com.example.campwith.remote.NetworkHelper.api
import io.reactivex.Single

class RemoteDataSourceImpl : RemoteDataSource {
    override fun signIn(
        body: SignInRequest
    ) = api.signIn(body)

    override fun signUp(
        body: SignUpRequest
    ) = api.signUp(body)

    override fun getRecommendCamp() = api.getRecommendCamp()

    override fun getCamp(
        doNm: String
    ) = api.getCamp(doNm)

    override fun getTypeCamp(
        type: Int
    ) = api.getTypeCamp(type)

    override fun getCampDetail(
        id: String
    ) = api.getCampDetail(id)

    override fun addReview(body: AddReviewBody) = api.addReview(body)

    override fun modifyReview(body: ModifyReviewBody) = api.modifyReview(body)

    override fun deleteReview(body: DeleteReviewBody) = api.deleteReview(body)

    override fun getCampCar(): Single<CampCarResponse> = api.getCampCar()

    override fun getCampTool(): Single<CampToolResponse> = api.getCampTool()
}