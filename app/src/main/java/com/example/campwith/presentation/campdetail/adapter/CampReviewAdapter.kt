package com.example.campwith.presentation.campdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.campwith.R
import com.example.campwith.data.review.response.ReviewResponseItem
import com.example.campwith.databinding.ItemCampReviewBinding

class CampReviewAdapter :
    ListAdapter<ReviewResponseItem, CampReviewAdapter.Holder>(CampReviewDiffCallback()) {

    private var reviewList = mutableListOf<ReviewResponseItem>()
    var onModifyClick: ((ReviewResponseItem, Int) -> Unit)? = null
    var onDeleteClick: ((Int) -> Unit)? = null

    fun deleteOne(position: Int) {
        reviewList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class Holder(private val binding: ItemCampReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(reviewItem: ReviewResponseItem) {
            binding.itemReview = reviewItem
            binding.tvModify.setOnClickListener {
                onModifyClick?.invoke(reviewItem, bindingAdapterPosition)
            }
            binding.tvRemove.setOnClickListener {
                onDeleteClick?.invoke(bindingAdapterPosition)
            }
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

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class CampReviewDiffCallback :
        DiffUtil.ItemCallback<ReviewResponseItem>() {
        override fun areItemsTheSame(
            oldItem: ReviewResponseItem,
            newItem: ReviewResponseItem
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ReviewResponseItem,
            newItem: ReviewResponseItem
        ) = oldItem == newItem
    }
}