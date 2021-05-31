package com.example.campwith.presentation.campdetail.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import com.example.campwith.R
import com.example.campwith.data.review.response.ReviewResponseItem
import com.example.campwith.databinding.ActivityReviewWriteBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.CAMP_ID
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.CAMP_NM
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.MODIFY
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.POSITION
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.REVIEW
import com.example.campwith.presentation.campdetail.view.CampReviewFragment.Companion.TYPE
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewWriteViewModel
import kotlinx.android.synthetic.main.activity_review_write.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewWriteActivity :
    BaseActivity<ActivityReviewWriteBinding, CampReviewWriteViewModel>(R.layout.activity_review_write) {
    override val viewModel: CampReviewWriteViewModel by viewModel()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = intent.getStringExtra(TYPE)
        val campId = intent.getStringExtra(CAMP_ID)
        val campNm = intent.getStringExtra(CAMP_NM)
        val review: ReviewResponseItem? = intent.getParcelableExtra(REVIEW)
        val position: Int = intent.getIntExtra(POSITION, -1)

        when (type) {
            MODIFY -> {
                binding.ratingBarReviewWrite.rating = review?.rating!!
                binding.editTextReview.setText(review.comment)
            }
        }

        binding.tvNm.text = campNm

        container_review.setOnTouchListener { view, motionEvent ->
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
            val result = Intent().apply {
                putExtras(
                    bundleOf(
                        TYPE to type,
                        REVIEW to
                                ReviewResponseItem(
                                    binding.editTextReview.text.toString(),
                                    binding.ratingBarReviewWrite.rating,
                                    "2099.99.99",
                                    "테스트"
                                ),
                        POSITION to position
                    )
                )
            }
            setResult(Activity.RESULT_OK, result)
            finish()
        }
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