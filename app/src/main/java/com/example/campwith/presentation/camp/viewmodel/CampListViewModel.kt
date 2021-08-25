package com.example.campwith.presentation.camp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.data.camp.response.CampResponseItem
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampListViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campListLiveData = MutableLiveData<List<CampResponseItem>>()
    val campListLiveData: LiveData<List<CampResponseItem>>
        get() = _campListLiveData

    fun getCampList(region: String) {
        addDisposable(
            remoteDataSourceImpl.getCamp(region)
                .applySchedulers()
                .subscribe(
                    {
                        _campListLiveData.value = it.result.campsiteList
                    }, {
                    }
                )
        )
    }

    fun getTypeCampList(type: Int) {
        addDisposable(
            remoteDataSourceImpl.getTypeCamp(type)
                .applySchedulers()
                .subscribe(
                    {
                        _campListLiveData.value = it.result.campsiteList
                    }, {
                    }
                )
        )
    }

    fun getBookmarkCampList() {
        addDisposable(
            remoteDataSourceImpl.getBookmarkCamp()
                .applySchedulers()
                .subscribe(
                    {
                        _campListLiveData.value = it.result.favorites
                    }, {

                    }
                )
        )
    }
}