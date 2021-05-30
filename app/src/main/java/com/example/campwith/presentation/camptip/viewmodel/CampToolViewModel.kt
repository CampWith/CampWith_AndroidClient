package com.example.campwith.presentation.camptip.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camp.response.CampToolResponse
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampToolViewModel : BaseViewModel() {

    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campToolLiveData = MutableLiveData<CampToolResponse>()
    val campToolLiveData: LiveData<CampToolResponse>
        get() = _campToolLiveData

    fun getCampTool() {
        addDisposable(
            remoteDataSourceImpl.getCampTool()
                .applySchedulers()
                .subscribe(
                    {
                        _campToolLiveData.value = it
                        Log.d("test1", it.toString())
                    }, {
                        Log.d("test2", it.toString())
                    }
                )
        )
    }
}