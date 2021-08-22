package com.example.campwith.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.campwith.R
import com.example.campwith.data.login.request.LoginRequest
import com.example.campwith.databinding.ActivityLoginBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.login.viewmodel.LoginViewModel
import com.example.campwith.presentation.main.view.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.loginBody = LoginRequest("", "")

        viewModel.event.observe(this, {
            it.getContentIfNotHandled()?.let { event ->
                if (event) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "회원정보가 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    companion object {
        const val TAG = "LoginActivity"
    }
}