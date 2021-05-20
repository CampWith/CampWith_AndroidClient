package com.example.campwith.presentation.camplist.view

import android.view.View
import com.example.campwith.data.camp.model.BannerItem

interface Interaction : View.OnClickListener {
    fun onBannerItemClicked(bannerItem: BannerItem)
}