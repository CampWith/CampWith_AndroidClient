package com.example.campwith.presentation.campdetail.view

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.review.response.ReviewResponseItem
import com.example.campwith.databinding.FragmentCampReviewBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.campdetail.adapter.CampReviewAdapter
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewViewModel
import kotlinx.android.synthetic.main.fragment_camp_review.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.content.ContextCompat


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
        val type = activityResult.data?.getStringExtra("type")
        val review = activityResult.data?.getParcelableExtra<ReviewResponseItem>("review")
        val position = activityResult.data?.getIntExtra("position", -1)

        if (review != null) {
            when (type) {
                MODIFY -> position?.let { modifyReview(review, it) }
                ADD -> addReview(review)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as CampDetailActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        campReviewAdapter.onModifyClick = { review, position ->
            val intent = Intent(currentActivity, ReviewWriteActivity::class.java)
            intent.putExtras(
                bundleOf(
                    "type" to MODIFY,
                    "campId" to campItem?._id,
                    "campNm" to campItem?.facltNm,
                    "review" to review,
                    "position" to position
                )
            )
            requestActivity.launch(intent)
        }

        campReviewAdapter.onDeleteClick = { position ->
            val builder: AlertDialog.Builder = AlertDialog.Builder(
                currentActivity,
                android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth
            )
            val dialog: AlertDialog = builder.setMessage("리뷰를 삭제할까요?")
                .setNegativeButton("취소") { textId, listener -> }
                .setPositiveButton("확인") { textId, listener ->
                    deleteReview(position)
                }.create()
            dialog.show()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(ContextCompat.getColor(currentActivity, R.color.red))
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(ContextCompat.getColor(currentActivity, R.color.gray))
        }

        rv_camp_review_list.adapter = campReviewAdapter

        binding.containerReviewWrite.setOnClickListener {
            val intent = Intent(currentActivity, ReviewWriteActivity::class.java)
            intent.putExtras(
                bundleOf(
                    "type" to ADD,
                    "campId" to campItem?._id,
                    "campNm" to campItem?.facltNm,
                    "review" to null,
                    "position" to null
                )
            )
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

    private fun addReview(review: ReviewResponseItem) {
        campReviewAdapter.addOne(review)
    }

    private fun modifyReview(review: ReviewResponseItem, position: Int) {
        campReviewAdapter.modifyOne(review, position)
    }

    private fun deleteReview(position: Int) {
        campReviewAdapter.deleteOne(position)
    }

    companion object {
        const val MODIFY = "MODIFY"
        const val ADD = "ADD"
    }
}