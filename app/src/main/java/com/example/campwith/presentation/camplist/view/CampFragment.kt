package com.example.campwith.presentation.camplist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCampBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.camplist.viewmodel.CampViewModel
import com.example.campwith.presentation.main.view.CityDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampFragment : BaseFragment<FragmentCampBinding, CampViewModel>(R.layout.fragment_camp) {
    override val viewModel: CampViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.llContainer.setOnClickListener {
            val cityDialogFragment = CityDialogFragment()
            activity?.let { it1 -> cityDialogFragment.show(it1.supportFragmentManager, "dialog") }
        }
    }
}