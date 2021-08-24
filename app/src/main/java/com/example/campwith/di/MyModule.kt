package com.example.campwith.di

import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel
import com.example.campwith.presentation.campcar.viewmodel.CampCarListViewModel
import com.example.campwith.presentation.campdetail.viewmodel.CampMapViewModel
import com.example.campwith.presentation.campdetail.viewmodel.CampReviewViewModel
import com.example.campwith.presentation.camp.viewmodel.CampListViewModel
import com.example.campwith.presentation.camp.viewmodel.CampViewModel
import com.example.campwith.presentation.camptip.viewmodel.CampTipViewModel
import com.example.campwith.presentation.camptool.viewmodel.CampToolViewModel
import com.example.campwith.presentation.signin.viewmodel.SignInViewModel
import com.example.campwith.presentation.main.viewmodel.CityDialogViewModel
import com.example.campwith.presentation.main.viewmodel.MainViewModel
import com.example.campwith.presentation.mypage.viewmodel.MyPageViewModel
import com.example.campwith.presentation.reviewwrite.viewmodel.ReviewWriteViewModel
import com.example.campwith.presentation.signup.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelPart = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        SignInViewModel()
    }
    viewModel {
        SignUpViewModel()
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
        ReviewWriteViewModel()
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
    viewModel {
        MyPageViewModel()
    }
}

val myDiModule = listOf(viewModelPart)
