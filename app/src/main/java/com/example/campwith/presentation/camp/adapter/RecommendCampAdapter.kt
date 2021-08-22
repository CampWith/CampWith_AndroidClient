package com.example.campwith.presentation.camp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.campwith.CampTypeConstant
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampResponseItem
import com.example.campwith.databinding.ItemRecommendCampBinding
import com.example.campwith.presentation.campdetail.view.CampDetailActivity

class RecommendCampAdapter(val context: Context) :
    RecyclerView.Adapter<RecommendCampAdapter.Holder>() {

    private var campList = mutableListOf<CampResponseItem>()

    fun addAll(newCampList: List<CampResponseItem>) {
        //campList.clear()
        campList.addAll(newCampList)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemRecommendCampBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(campItem: CampResponseItem) {
            binding.itemCamp = campItem
            Glide.with(itemView)
                .load(campItem.firstImageUrl)
                .into(binding.ivCampItem)
            binding.tvCampType.text = CampTypeConstant.getTypeName(campItem.category)
            binding.cvRecommandCampItem.setOnClickListener {
                val intent = Intent(context, CampDetailActivity::class.java)
                intent.putExtra("id", campItem._id)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recommend_camp,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = campList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(campList[position])
    }
}