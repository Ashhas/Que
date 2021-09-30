package com.example.que.di

import com.example.que.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { DashboardViewModel(quoteRepo = get()) }

}