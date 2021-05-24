package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.camp.response.ReviewResponseItem
import com.example.campwith.presentation.campdetail.adapter.CampReviewAdapter
import kotlinx.android.synthetic.main.fragment_camp_review.*

private const val ARG_PARAM = "campItem"

class CampReviewFragment : Fragment() {
    private var campItem: CampDetailResponse? = null
    private val campReviewAdapter = CampReviewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        arguments?.let {
            campItem = it.getParcelable(ARG_PARAM)
        }

        return inflater.inflate(R.layout.fragment_camp_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_camp_review_list.adapter = campReviewAdapter
    }

    fun addReview(reviews: List<ReviewResponseItem>) {
        campReviewAdapter.addAll(reviews)
    }
}