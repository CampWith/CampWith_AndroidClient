package com.example.campwith.presentation.campcar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.campwith.R
import com.example.campwith.data.campcar.CampCarResponse
import com.example.campwith.data.campcar.CampCarResponseItem
import com.example.campwith.databinding.ItemCampCarBinding

class CampCarListAdapter(val context: Context) : RecyclerView.Adapter<CampCarListAdapter.Holder>() {

    private var campCarList = CampCarResponse()

    fun addAll(newCampCarList: CampCarResponse) {
        campCarList.clear()
        campCarList.addAll(newCampCarList)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCampCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(campCarItem: CampCarResponseItem) {
            binding.itemCampCar = campCarItem
            Glide.with(itemView)
                .load(campCarItem.image)
                .into(binding.ivCampCarItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_camp_car,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = campCarList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(campCarList[position])
    }
}