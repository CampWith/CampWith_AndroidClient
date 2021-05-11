package com.example.campwith.di

import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel
import com.example.campwith.presentation.camplist.viewmodel.CampListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelPart = module {
    viewModel {
        CampListViewModel()
    }
    viewModel {
        CampDetailViewModel()
    }
}

val myDiModule = listOf(viewModelPart)
