package com.example.campwith.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.campwith.R
import com.example.campwith.presentation.login.LoginActivity
import com.example.campwith.presentation.main.view.MainActivity
import com.kakao.sdk.user.UserApiClient

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    Log.e(TAG, "토큰 정보 보기 실패", error)
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else if (tokenInfo != null) {
                    Log.i(
                        TAG, "토큰 정보 보기 성공" +
                                "\n회원번호: ${tokenInfo.id}" +
                                "\n만료시간: ${tokenInfo.expiresIn} 초"
                    )
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

        }, SPLASH_DELAY_TIME)
    }

    companion object {
        const val TAG = "SplashActivity"
        private const val SPLASH_DELAY_TIME: Long = 1500
    }
}