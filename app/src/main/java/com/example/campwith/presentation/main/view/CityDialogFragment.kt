package com.example.campwith.presentation.main.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCityDialogBinding
import com.example.campwith.presentation.base.BaseDialogFragment
import com.example.campwith.presentation.main.viewmodel.CityDialogFragmentViewModel

class CityDialogFragment : BaseDialogFragment<FragmentCityDialogBinding>(R.layout.fragment_city_dialog) {

    private lateinit var cityDialogFragmentViewModel: CityDialogFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cityDialogFragmentViewModel = ViewModelProvider(this).get(CityDialogFragmentViewModel::class.java)
        cityDialogFragmentViewModel.getCampList()
    }
}