package com.example.campwith.di

import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel
import com.example.campwith.presentation.campcarlist.viewmodel.CampCarListViewModel
import com.example.campwith.presentation.campdetail.viewmodel.CampMapViewModel
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewViewModel
import com.example.campwith.presentation.camplist.viewmodel.CampListViewModel
import com.example.campwith.presentation.camplist.viewmodel.CampViewModel
import com.example.campwith.presentation.camptip.viewmodel.CampTipViewModel
import com.example.campwith.presentation.camptip.viewmodel.CampToolViewModel
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
        CampReviewViewModel()
    }
    viewModel {
        CampMapViewModel()
    }
    viewModel {
        CampCarListViewModel()
    }
    viewModel {
        CampTipViewModel()
    }
    viewModel {
        CampToolViewModel()
    }
}

val myDiModule = listOf(viewModelPart)
