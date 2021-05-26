package com.example.campwith.presentation.campdetail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.camp.response.ReviewResponseItem
import com.example.campwith.databinding.FragmentCampReviewBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.campdetail.adapter.CampReviewAdapter
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewViewModel
import kotlinx.android.synthetic.main.fragment_camp_review.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM = "campItem"

class CampReviewFragment :
    BaseFragment<FragmentCampReviewBinding, CampReviewViewModel>(R.layout.fragment_camp_review) {
    override val viewModel: CampReviewViewModel by viewModel()
    private var campItem: CampDetailResponse? = null
    private val campReviewAdapter = CampReviewAdapter()
    private lateinit var currentActivity: CampDetailActivity
    private val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult() // StartActivityForResult 처리를 담당
    ) { activityResult ->
        val review = activityResult.data?.getParcelableExtra<ReviewResponseItem>("Review")
        if (review != null) {
            addReview(review)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as CampDetailActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_camp_review_list.adapter = campReviewAdapter
        binding.containerReviewWrite.setOnClickListener {
            val intent = Intent(currentActivity, ReviewWriteActivity::class.java)
            intent.putExtras(bundleOf("campId" to campItem?._id, "campNm" to campItem?.facltNm))
            requestActivity.launch(intent)
        }
    }

    fun getData() {
        arguments?.let {
            campItem = it.getParcelable(ARG_PARAM)
        }
    }

    fun addReviews(reviews: List<ReviewResponseItem>) {
        campReviewAdapter.addAll(reviews)
    }

    fun addReview(review: ReviewResponseItem) {
        campReviewAdapter.addOne(review)
    }
}