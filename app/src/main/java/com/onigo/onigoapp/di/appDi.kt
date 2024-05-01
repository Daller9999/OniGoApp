package com.onigo.onigoapp.di

import com.onigo.onigoapp.screens.login.LoginViewModel
import com.onigo.onigoapp.screens.result.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appDi = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ResultViewModel() }
}