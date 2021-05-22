package com.example.campwith.di

import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel
import com.example.campwith.presentation.campcarlist.viewmodel.CampCarListViewModel
import com.example.campwith.presentation.camplist.viewmodel.CampListViewModel
import com.example.campwith.presentation.camplist.viewmodel.CampViewModel
import com.example.campwith.presentation.main.viewmodel.CityDialogViewModel
import com.example.campwith.presentation.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelPart = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        CityDialogViewModel()
    }
    viewModel {
        CampViewModel()
    }
    viewModel {
        CampListViewModel()
    }
    viewModel {
        CampDetailViewModel()
    }
    viewModel {
        CampCarListViewModel()
    }
}

val myDiModule = listOf(viewModelPart)
