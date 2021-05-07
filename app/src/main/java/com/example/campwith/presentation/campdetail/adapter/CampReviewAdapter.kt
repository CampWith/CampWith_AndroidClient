package com.example.campwith.presentation.campdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.campwith.R
import com.example.campwith.data.review.Item
import com.example.campwith.databinding.ItemCampReviewBinding

class CampReviewAdapter() : RecyclerView.Adapter<CampReviewAdapter.Holder>() {

    private var reviewList = mutableListOf<Item>()

    fun addAll(newReviewList: List<Item>) {
        reviewList.clear()
        reviewList.addAll(newReviewList)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCampReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(reviewItem: Item) {
            binding.itemReview = reviewItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_camp_review,
            parent,
            false
        )
    )

    override fun getItemCount() = reviewList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(reviewList[position])
    }
}