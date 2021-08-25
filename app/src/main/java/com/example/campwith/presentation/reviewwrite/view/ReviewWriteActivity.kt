package com.example.campwith.presentation.reviewwrite.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.campwith.R
import com.example.campwith.data.review.request.AddReviewBody
import com.example.campwith.data.review.request.ModifyReviewBody
import com.example.campwith.data.review.response.ReviewResponseItem
import com.example.campwith.databinding.ActivityReviewWriteBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.ADD
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.CAMP_ID
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.CAMP_NM
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.MODIFY
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.REVIEW
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.TYPE
import com.example.campwith.presentation.reviewwrite.viewmodel.ReviewWriteViewModel
import kotlinx.android.synthetic.main.activity_review_write.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewWriteActivity :
    BaseActivity<ActivityReviewWriteBinding, ReviewWriteViewModel>(R.layout.activity_review_write) {
    override val viewModel: ReviewWriteViewModel by viewModel()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = intent.getStringExtra(TYPE)
        val campId = intent.getStringExtra(CAMP_ID)
        val campNm = intent.getStringExtra(CAMP_NM)
        val review: ReviewResponseItem? = intent.getParcelableExtra(REVIEW)

        when (type) {
            MODIFY -> {
                binding.ratingBarReviewWrite.rating = review?.rating!!
                binding.editTextReview.setText(review.comment)
            }
        }

        binding.tvNm.text = campNm

        binding.containerReview.setOnTouchListener { _, _ ->
            if (binding.editTextReview.isFocused) {
                hideKeyboard()
                false
            } else {
                false
            }
        }

        this.runOnUiThread {
            binding.toolbarActivityCampReviewWrite.run {
                setBackBtnVisible(false)
                setCancleBtnVisible(true)
                setLogoVisible(false)
                setCancleBtnClick { finish() }
            }
        }

        binding.tvReviewRegister.setOnClickListener {
            val comment = binding.editTextReview.text.toString()
            val rating = binding.ratingBarReviewWrite.rating

            when (type) {
                ADD -> viewModel.addReview(AddReviewBody(campId!!, comment, rating))
                MODIFY -> viewModel.modifyReview(ModifyReviewBody(review!!._id, comment, rating))
            }
        }

        viewModel.event.observe(this, {
            it.getContentIfNotHandled()?.let { event ->
                if (event) {
                    finish()
                }
            }
        })
    }

    private fun hideKeyboard() {
        val inputManager: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            this.currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}