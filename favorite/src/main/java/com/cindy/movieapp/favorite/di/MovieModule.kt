package com.cindy.movieapp.favorite.di

import com.cindy.movieapp.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {
    viewModel { FavoriteViewModel(get()) }
}