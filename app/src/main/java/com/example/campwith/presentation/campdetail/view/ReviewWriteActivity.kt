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
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewWriteViewModel
import kotlinx.android.synthetic.main.activity_review_write.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewWriteActivity :
    BaseActivity<ActivityReviewWriteBinding, CampReviewWriteViewModel>(R.layout.activity_review_write) {
    override val viewModel: CampReviewWriteViewModel by viewModel()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = intent.getStringExtra("type")
        val campId = intent.getStringExtra("campId")
        val campNm = intent.getStringExtra("campNm")
        val review: ReviewResponseItem? = intent.getParcelableExtra("review")
        val position: Int = intent.getIntExtra("position", -1)

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
                        "type" to type,
                        "review" to
                                ReviewResponseItem(
                                    binding.editTextReview.text.toString(),
                                    binding.ratingBarReviewWrite.rating,
                                    "2099.99.99",
                                    "테스트"
                                ),
                        "position" to position
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

    companion object {
        const val MODIFY = "MODIFY"
        const val ADD = "ADD"
    }
}