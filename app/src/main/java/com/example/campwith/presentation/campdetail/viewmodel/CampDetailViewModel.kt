package com.example.campwith.presentation.campdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camp.CampDetailResponse
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampDetailViewModel : BaseViewModel() {

    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campDetailLiveData = MutableLiveData<CampDetailResponse>()
    val campDetailLiveData: LiveData<CampDetailResponse>
        get() = _campDetailLiveData

    fun getCampDetail(id: String) {
        addDisposable(
            remoteDataSourceImpl.getCampDetail(id)
                .applySchedulers()
                .subscribe(
                    {
                        _campDetailLiveData.value = it
                        Log.d("test1", it.toString())
                    }, {
                        Log.d("test2", it.toString())
                    }
                )
        )
    }
}