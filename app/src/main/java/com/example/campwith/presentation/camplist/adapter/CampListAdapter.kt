package com.example.campwith.presentation.camplist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.campwith.R
import com.example.campwith.data.Item
import com.example.campwith.databinding.ItemCampBinding

class CampListAdapter() : RecyclerView.Adapter<CampListAdapter.Holder>() {

    private var campList = mutableListOf<Item>()

    fun addAll(newCampList: List<Item>){
        campList.clear()
        campList.addAll(newCampList)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCampBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(campItem: Item){
            binding.itemCamp = campItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
        = Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_camp, parent, false))

    override fun getItemCount(): Int = campList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(campList[position])
    }
}