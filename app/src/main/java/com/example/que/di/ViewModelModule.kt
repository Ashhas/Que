package com.example.que.di

import com.example.que.ui.dashboard.DashboardViewModel
import com.example.que.ui.main.QueViewModel
import com.example.que.ui.storage.StorageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { QueViewModel(quoteRepo = get()) }
    viewModel { DashboardViewModel(quoteRepo = get()) }
    viewModel { StorageViewModel(quoteRepo = get()) }

}