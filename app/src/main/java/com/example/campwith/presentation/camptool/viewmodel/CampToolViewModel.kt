package com.example.campwith.presentation.camptool.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camptool.model.CampToolModel
import com.example.campwith.data.camptool.response.toModel
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampToolViewModel : BaseViewModel() {

    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _campToolLiveData = MutableLiveData<List<CampToolModel>>()
    val campToolLiveData: LiveData<List<CampToolModel>>
        get() = _campToolLiveData

    fun getCampTool() {
        addDisposable(
            remoteDataSourceImpl.getCampTool()
                .applySchedulers()
                .subscribe(
                    {
                        _campToolLiveData.value =
                            it.result.campingtoolList.map { response -> response.toModel() }
                        Log.d("test1", it.toString())
                    }, {
                        Log.d("test2", it.toString())
                    }
                )
        )
    }
}