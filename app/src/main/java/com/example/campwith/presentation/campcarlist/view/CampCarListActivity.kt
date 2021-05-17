package com.example.campwith.presentation.campcarlist.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.campwith.R
import com.example.campwith.databinding.ActivityCampCarBinding
import com.example.campwith.databinding.ActivityCampListBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campcarlist.viewmodel.CampCarListViewModel
import com.example.campwith.presentation.campcarlist.adapter.CampCarListAdapter
import kotlinx.android.synthetic.main.activity_camp_car.*
import kotlinx.android.synthetic.main.activity_camp_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampCarListActivity :
    BaseActivity<ActivityCampCarBinding, CampCarListViewModel>(R.layout.activity_camp_car) {

    override val viewModel: CampCarListViewModel by viewModel()
    private val campCarListAdapter = CampCarListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getCampCarList()

        rc_camp_car_list.adapter = campCarListAdapter

        viewModel.campCarListLiveData.observe(this,
            Observer {
                campCarListAdapter.addAll(it)
            })
    }
}