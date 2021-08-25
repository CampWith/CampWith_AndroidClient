package com.example.campwith.presentation.campdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.bookmark.request.BookmarkRequest
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.Event
import com.example.campwith.util.applySchedulers

class CampDetailViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campDetailLiveData = MutableLiveData<CampDetailResponse>()
    val campDetailLiveData: LiveData<CampDetailResponse>
        get() = _campDetailLiveData
    private val _event = MutableLiveData<Event<String>>()
    val event: LiveData<Event<String>>
        get() = _event

    fun getCampDetail(id: String) {
        addDisposable(
            remoteDataSourceImpl.getCampDetail(id)
                .applySchedulers()
                .subscribe(
                    {
                        Log.d("이미지", it.result.is_favorite.toString())
                        _campDetailLiveData.value = it
                    }, {
                    }
                )
        )
    }

    fun addBookmark(body: BookmarkRequest) {
        addDisposable(
            remoteDataSourceImpl.addBookmark(body)
                .applySchedulers()
                .subscribe({
                    _event.value = Event(ADD_BOOKMARK)
                }, {})
        )
    }

    fun deleteBookmark(body: BookmarkRequest) {
        addDisposable(
            remoteDataSourceImpl.deleteBookmark(body)
                .applySchedulers()
                .subscribe({
                    _event.value = Event(DELETE_BOOKMARK)
                }, {})
        )
    }

    companion object {
        const val ADD_BOOKMARK = "ADD_BOOKMARK"
        const val DELETE_BOOKMARK = "DELETE_BOOKMARK"
    }
}