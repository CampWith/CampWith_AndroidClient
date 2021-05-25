package com.example.campwith.presentation.camp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camp.response.CampResponse
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampListViewModel : BaseViewModel() {

    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campListLiveData = MutableLiveData<CampResponse>()
    val campListLiveData: LiveData<CampResponse>
        get() = _campListLiveData

    fun getCampList(region: String) {
        addDisposable(
            remoteDataSourceImpl.getCamp(region)
                .applySchedulers()
                .subscribe(
                    {
                        _campListLiveData.value = it
                        Log.d("test1", it.toString())
                    }, {
                        Log.d("test2", it.toString())
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
                        _campListLiveData.value = it
                        Log.d("test1", it.toString())
                    }, {
                        Log.d("test2", it.toString())
                    }
                )
        )
    }
}