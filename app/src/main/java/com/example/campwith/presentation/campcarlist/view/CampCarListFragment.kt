package com.example.campwith.presentation.campcarlist.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCampCarBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.campcarlist.viewmodel.CampCarListViewModel
import com.example.campwith.presentation.campcarlist.adapter.CampCarListAdapter
import kotlinx.android.synthetic.main.fragment_camp_car.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampCarListFragment :
    BaseFragment<FragmentCampCarBinding, CampCarListViewModel>(R.layout.fragment_camp_car) {

    override val viewModel: CampCarListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCampCarList()

        val campCarListAdapter = activity?.let { CampCarListAdapter(it) }

        rc_camp_car_list.adapter = campCarListAdapter

        viewModel.campCarListLiveData.observe(viewLifecycleOwner,
            Observer {
                campCarListAdapter?.addAll(it)
            })
    }
}