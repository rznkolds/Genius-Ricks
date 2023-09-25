package com.rznkolds.geniusricks.di

import com.rznkolds.geniusricks.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {

        MainViewModel(get())
    }
}