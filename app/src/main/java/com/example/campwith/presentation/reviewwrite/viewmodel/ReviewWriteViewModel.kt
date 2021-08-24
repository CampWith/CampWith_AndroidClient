package com.example.campwith.presentation.reviewwrite.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.review.request.AddReviewBody
import com.example.campwith.data.review.request.ModifyReviewBody
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.Event
import com.example.campwith.util.applySchedulers

class ReviewWriteViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _event = MutableLiveData<Event<Boolean>>()
    val event: LiveData<Event<Boolean>>
        get() = _event

    fun addReview(body: AddReviewBody) {
        addDisposable(
            remoteDataSourceImpl.addReview(body)
                .applySchedulers()
                .subscribe(
                    {
                        if (it.success) {
                            _event.value = Event(true)
                        }
                    }, {}
                )
        )
    }

    fun modifyReview(body: ModifyReviewBody) {
        addDisposable(
            remoteDataSourceImpl.modifyReview(body)
                .applySchedulers()
                .subscribe(
                    {
                        if (it.success) {
                            _event.value = Event(true)
                        }
                    }, {}
                )
        )
    }
}