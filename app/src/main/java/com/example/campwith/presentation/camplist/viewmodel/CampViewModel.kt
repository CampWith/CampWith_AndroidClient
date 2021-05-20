package com.example.campwith.presentation.camplist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camp.model.BannerItem
import com.example.campwith.presentation.base.BaseViewModel

class CampViewModel : BaseViewModel() {
    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()
    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()

    val bannerItemList: LiveData<List<BannerItem>>
        get() = _bannerItemList
    val currentPosition: LiveData<Int>
        get() = _currentPosition

    init {
        _currentPosition.value = 0
    }

    fun setBannerItems(list: List<BannerItem>) {
        _bannerItemList.value = list
    }

    fun setCurrentPosition(position: Int) {
        _currentPosition.value = position
    }

    fun getcurrentPosition() = currentPosition.value
}