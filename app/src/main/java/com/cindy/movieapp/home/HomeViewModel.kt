package com.cindy.movieapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cindy.movieapp.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movies = movieUseCase.getAllMovie().asLiveData()
}