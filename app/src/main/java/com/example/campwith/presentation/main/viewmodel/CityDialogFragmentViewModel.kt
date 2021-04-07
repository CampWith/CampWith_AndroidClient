package com.example.campwith.presentation.main.viewmodel

import android.util.Log
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CityDialogFragmentViewModel : BaseViewModel() {

    private val SERVICE_KEY = "ro4yuqfYiG69v64HUnTBvlD3P153Jqi58047c4Xi31SR0I1kjr445lQgKsMQIl5Nlg4b3p+/sMsPpQtPpPqx2g=="
    private val MOBILE_OS = "AND"
    private val MOBILE_APP = "CampWith"
    private val TYPE = "json"
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    fun getCampList(){
        addDisposable(
            remoteDataSourceImpl.getCamp(
                SERVICE_KEY,
                MOBILE_OS,
                MOBILE_APP,
                TYPE,
                1,
                10
            )
            .applySchedulers()
            .subscribe(
                {
                    Log.d("test1", it.toString())
                },{
                    Log.d("test2", it.toString())
                }
            )
        )
    }
}