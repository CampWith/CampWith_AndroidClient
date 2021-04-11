package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import com.example.campwith.R
import com.example.campwith.databinding.ActivityCampDetailBinding
import com.example.campwith.presentation.base.BaseActivity

class CampDetailActivity : BaseActivity<ActivityCampDetailBinding>(R.layout.activity_camp_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.itemCamp = intent.getParcelableExtra("campitem")

    }
}