package com.example.campwith.presentation.camp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.campwith.data.camp.response.RecommendCampResponse
import com.example.campwith.data.banner.model.BannerModel
import com.example.campwith.presentation.base.BaseViewModel
import com.example.campwith.remote.RemoteDataSourceImpl
import com.example.campwith.util.applySchedulers

class CampViewModel : BaseViewModel() {
    private val remoteDataSourceImpl = RemoteDataSourceImpl()

    private val _bannerItemList: MutableLiveData<List<BannerModel>> = MutableLiveData()
    val bannerItemList: LiveData<List<BannerModel>>
        get() = _bannerItemList

    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()
    val currentPosition: LiveData<Int>
        get() = _currentPosition

    private val _campListLiveData = MutableLiveData<RecommendCampResponse>()
    val campListLiveData: LiveData<RecommendCampResponse>
        get() = _campListLiveData

    init {
        _currentPosition.value = 0
    }

    fun getRecommendCampList() {
        addDisposable(
            remoteDataSourceImpl.getRecommendCamp()
                .applySchedulers()
                .subscribe(
                    {
                        Log.d("추천", "성공" + it.toString())
                        _campListLiveData.value = it
                    }, {
                        Log.d("추천", it.toString())
                    }
                )
        )
    }

    fun setBannerItems(list: List<BannerModel>) {
        _bannerItemList.value = list
    }

    fun setCurrentPosition(position: Int) {
        _currentPosition.value = position
    }

    fun getCurrentPosition() = currentPosition.value
}