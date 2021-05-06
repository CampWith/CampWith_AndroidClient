package com.example.campwith.presentation.camplist.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.campwith.R
import com.example.campwith.databinding.ActivityCampListBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.camplist.viewmodel.CampListViewModel
import com.example.campwith.presentation.camplist.adapter.CampListAdapter
import com.naver.maps.map.NaverMapSdk
import kotlinx.android.synthetic.main.activity_camp_list.*

class CampListActivity : BaseActivity<ActivityCampListBinding>(R.layout.activity_camp_list) {

    private lateinit var campListViewModel: CampListViewModel
    private val campListAdapter = CampListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("acdbyskku1")

        val region = intent.getStringExtra("doName")
        tv_do_name.text = region

        campListViewModel = ViewModelProvider(this).get(CampListViewModel::class.java)
        if (region != null) {
            campListViewModel.getCampList(region)
        }

        rv_camp_list.adapter = campListAdapter

        campListViewModel.campListLiveData.observe(this,
            Observer {
                campListAdapter.addAll(it)
        })
    }
}