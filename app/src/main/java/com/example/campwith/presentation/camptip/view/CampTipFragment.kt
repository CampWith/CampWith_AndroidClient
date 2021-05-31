package com.example.campwith.presentation.camptip.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCampTipBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.camptip.viewmodel.CampTipViewModel
import com.example.campwith.presentation.camptool.view.CampToolActivity
import com.example.campwith.presentation.main.view.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampTipFragment :
    BaseFragment<FragmentCampTipBinding, CampTipViewModel>(R.layout.fragment_camp_tip) {
    override val viewModel: CampTipViewModel by viewModel()
    private lateinit var currentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentActivity.runOnUiThread {
            binding.toolbarFragmentCampTip.run {
                setBackBtnVisible(false)
                setCancleBtnVisible(false)
                setLogoVisible(false)
                setTitle("캠핑팁")
            }
        }

        binding.ivCampTool.setOnClickListener {
            val intent = Intent(currentActivity, CampToolActivity::class.java)
            startActivity(intent)
        }
    }
}