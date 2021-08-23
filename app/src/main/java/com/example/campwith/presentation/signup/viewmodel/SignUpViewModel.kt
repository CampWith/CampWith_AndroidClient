package com.example.campwith.presentation.signup.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.User
import com.example.campwith.data.signup.request.SignUpRequest
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.Event
import com.example.campwith.util.applySchedulers

class SignUpViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()
    private val _event = MutableLiveData<Event<Boolean>>()
    val event: LiveData<Event<Boolean>>
        get() = _event

    fun signUp(body: SignUpRequest) {
        addDisposable(
            remoteDataSourceImpl.signUp(body)
                .applySchedulers()
                .subscribe(
                    {
                        Log.d("회원가입 성공", it.token)
                        _event.value = Event(true)
                        User.token = it.token
                    }, {
                        _event.value = Event(false)
                    }
                )
        )
    }
}