package com.example.campwith.presentation.signup.view

import com.example.campwith.presentation.signup.viewmodel.SignUpViewModel
import android.os.Bundle
import android.widget.Toast
import com.example.campwith.R
import com.example.campwith.data.signup.request.SignUpRequest
import com.example.campwith.databinding.ActivitySignUpBinding
import com.example.campwith.presentation.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding, SignUpViewModel>(R.layout.activity_sign_up) {
    override val viewModel: SignUpViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.signUpBody = SignUpRequest("", "", "")

        viewModel.event.observe(this, {
            it.getContentIfNotHandled()?.let { event ->
                if (event) {
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}