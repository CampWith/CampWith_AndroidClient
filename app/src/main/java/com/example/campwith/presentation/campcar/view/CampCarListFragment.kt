package com.example.campwith.presentation.campcar.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCampCarBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.campcar.viewmodel.CampCarListViewModel
import com.example.campwith.presentation.campcar.adapter.CampCarListAdapter
import com.example.campwith.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_camp_car.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampCarListFragment :
    BaseFragment<FragmentCampCarBinding, CampCarListViewModel>(R.layout.fragment_camp_car) {
    override val viewModel: CampCarListViewModel by viewModel()
    private lateinit var currentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentActivity.runOnUiThread {
            binding.toolbarFragmentCampCar.run {
                setBackBtnVisible(false)
                setCancleBtnVisible(false)
                setLogoVisible(false)
                setTitle("캠핑카")
            }
        }

        viewModel.getCampCarList()

        val campCarListAdapter = CampCarListAdapter(currentActivity)

        rc_camp_car_list.adapter = campCarListAdapter

        viewModel.campCarListLiveData.observe(
            viewLifecycleOwner,
            {
                campCarListAdapter.addAll(it)
            })
    }
}