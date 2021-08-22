package com.example.campwith.presentation.login.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.User
import com.example.campwith.data.login.request.LoginRequest
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.Event
import com.example.campwith.util.applySchedulers

class LoginViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _event = MutableLiveData<Event<Boolean>>()
    val event: LiveData<Event<Boolean>>
        get() = _event

    fun signIn(body: LoginRequest) {
        addDisposable(
            remoteDataSourceImpl.signIn(body)
                .applySchedulers()
                .subscribe(
                    {
                        Log.d("로그인 성공", it.token)
                        _event.value = Event(true)
                        User.token = it.token
                    }, {
                        _event.value = Event(false)
                    }
                )
        )
    }
}