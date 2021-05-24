package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import android.view.View
import com.example.campwith.R
import com.example.campwith.databinding.ActivityReviewWriteBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewWriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewWriteActivity :
    BaseActivity<ActivityReviewWriteBinding, CampReviewWriteViewModel>(R.layout.activity_review_write) {
    override val viewModel: CampReviewWriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.runOnUiThread {
            binding.toolbarActivityCampReviewWrite.run {
                setBackBtnVisible(false)
                setCancleBtnVisible(true)
                setLogoVisible(false)
                setCancleBtnClick(View.OnClickListener { finish() })
            }
        }
    }
}