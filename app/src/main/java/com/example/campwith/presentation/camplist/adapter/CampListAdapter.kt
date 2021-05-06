package com.example.campwith.presentation.camplist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.campwith.R
import com.example.campwith.data.camp.CampItem
import com.example.campwith.data.camp.CampResponse
import com.example.campwith.databinding.ItemCampBinding
import com.example.campwith.presentation.campdetail.view.CampDetailActivity

class CampListAdapter(val context: Context) : RecyclerView.Adapter<CampListAdapter.Holder>() {

    private var campList = CampResponse()

    fun addAll(newCampList: CampResponse) {
        campList.clear()
        campList.addAll(newCampList)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCampBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(campItem: CampItem) {
            binding.itemCamp = campItem
            Glide.with(itemView)
                .load(campItem.firstImageUrl)
                .into(binding.ivCampItem)
            binding.cvCampItem.setOnClickListener {
                val intent = Intent(context, CampDetailActivity::class.java)
                intent.putExtra("campitem", campItem)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
        = Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_camp, parent, false))

    override fun getItemCount(): Int = campList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(campList[position])
    }
}