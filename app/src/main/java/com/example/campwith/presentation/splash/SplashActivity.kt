package com.example.campwith.presentation.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campwith.R
import com.example.campwith.presentation.login.view.LoginActivity
import com.example.campwith.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val loginIntent = Intent(this, LoginActivity::class.java)
        val mainIntent = Intent(this, MainActivity::class.java)

        splash.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                startActivity(loginIntent)
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }
        })
    }

    companion object {
        const val TAG = "SplashActivity"
    }
}