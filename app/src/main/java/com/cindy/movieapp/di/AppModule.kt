package com.cindy.movieapp.di

import com.cindy.movieapp.core.domain.usecase.MovieInteractor
import com.cindy.movieapp.core.domain.usecase.MovieUseCase
import com.cindy.movieapp.detail.DetailViewModel
import com.cindy.movieapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}