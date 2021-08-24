package com.example.campwith.presentation.signin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.User
import com.example.campwith.data.signin.request.SignInRequest
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.Event
import com.example.campwith.util.applySchedulers

class SignInViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _event = MutableLiveData<Event<Boolean>>()
    val event: LiveData<Event<Boolean>>
        get() = _event

    fun signIn(body: SignInRequest) {
        addDisposable(
            remoteDataSourceImpl.signIn(body)
                .applySchedulers()
                .subscribe(
                    {
                        _event.value = Event(true)
                        User.token = it.result.token
                        User.uid = it.result.uid
                        Log.d("로그인", User.uid)
                    }, {
                        _event.value = Event(false)
                    }
                )
        )
    }
}