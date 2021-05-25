package com.example.campwith.presentation.camp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campwith.R
import com.example.campwith.data.camp.model.BannerItem
import com.example.campwith.presentation.camp.view.Interaction
import kotlinx.android.synthetic.main.item_banner.view.*

class ViewPagerAdapter(private val interaction: Interaction) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_COUNT = 2
    }

    private var bannerItemList: List<BannerItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BannerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false),
            interaction
        )
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bannerItemList?.let { bannerItemList ->
            (holder as BannerViewHolder).bind(bannerItemList[position])
        }
    }

    fun submitList(list: List<BannerItem>?) {
        bannerItemList = list
        notifyDataSetChanged()
    }

    class BannerViewHolder
    constructor(itemView: View, private val interaction: Interaction) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(bannerItem: BannerItem) {
            itemView.setOnClickListener {
                interaction.onBannerItemClicked(bannerItem)
            }
            itemView.iv_banner_image.setImageResource(bannerItem.image)
        }
    }
}