package com.example.campwith.presentation.signin.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.campwith.R
import com.example.campwith.data.signin.request.SignInRequest
import com.example.campwith.databinding.ActivitySignInBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.signin.viewmodel.SignInViewModel
import com.example.campwith.presentation.main.view.MainActivity
import com.example.campwith.presentation.signup.view.SignUpActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity :
    BaseActivity<ActivitySignInBinding, SignInViewModel>(R.layout.activity_sign_in) {
    override val viewModel: SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.signInBody = SignInRequest("", "")

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        viewModel.event.observe(this, {
            it.getContentIfNotHandled()?.let { event ->
                if (event) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "회원정보가 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}