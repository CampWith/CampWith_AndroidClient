package com.example.campwith.presentation.camp.view

import android.view.View
import com.example.campwith.data.banner.model.BannerModel

interface Interaction : View.OnClickListener {
    fun onBannerItemClicked(bannerItem: BannerModel)
}