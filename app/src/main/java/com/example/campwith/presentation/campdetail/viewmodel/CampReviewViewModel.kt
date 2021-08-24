package com.example.campwith.presentation.campdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.review.request.DeleteReviewBody
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.Event
import com.example.campwith.util.applySchedulers

class CampReviewViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _event = MutableLiveData<Event<Boolean>>()
    val event: LiveData<Event<Boolean>>
        get() = _event

    fun deleteReview(body: DeleteReviewBody) {
        addDisposable(
            remoteDataSourceImpl.deleteReview(body)
                .applySchedulers()
                .subscribe({
                    if (it.success) {
                        _event.value = Event(true)
                    }
                }, {})
        )
    }
}