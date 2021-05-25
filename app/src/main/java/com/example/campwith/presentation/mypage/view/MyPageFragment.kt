package com.example.campwith.presentation.mypage.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.campwith.R
import com.example.campwith.databinding.FragmentMypageBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.login.LoginActivity
import com.example.campwith.presentation.main.view.MainActivity
import com.example.campwith.presentation.mypage.viewmodel.MyPageViewModel
import com.kakao.sdk.user.UserApiClient
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageFragment :
    BaseFragment<FragmentMypageBinding, MyPageViewModel>(R.layout.fragment_mypage) {
    override val viewModel: MyPageViewModel by viewModel()
    private lateinit var currentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentActivity.runOnUiThread {
            binding.toolbarFragmentMypage.run {
                setBackBtnVisible(false)
                setCancleBtnVisible(false)
                setLogoVisible(false)
                setTitle("마이페이지")
            }
        }

        binding.btnLogout.setOnClickListener {
            // 로그아웃
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Log.e(TAG, "로그아웃 실패. SDK에서 토큰 삭제됨", error)
                } else {
                    Log.i(TAG, "로그아웃 성공. SDK에서 토큰 삭제됨")
                    val intent = Intent(currentActivity, LoginActivity::class.java)
                    startActivity(intent)
                    currentActivity.finish()
                }
            }
        }
    }

    companion object {
        const val TAG = "MyPageFragment"
    }
}