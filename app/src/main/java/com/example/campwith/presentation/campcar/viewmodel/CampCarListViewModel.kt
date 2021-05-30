package com.example.campwith.presentation.campcar.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampCarListViewModel : BaseViewModel() {

    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campCarListLiveData = MutableLiveData<CampCarResponse>()
    val campCarListLiveData: LiveData<CampCarResponse>
        get() = _campCarListLiveData

    fun getCampCarList() {
        addDisposable(
            remoteDataSourceImpl.getCampCar()
                .applySchedulers()
                .subscribe(
                    {
                        _campCarListLiveData.value = it
                        Log.d("test1", it.toString())
                    }, {
                        Log.d("test2", it.toString())
                    }
                )
        )
    }
}