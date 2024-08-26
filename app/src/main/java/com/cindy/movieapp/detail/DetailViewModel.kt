package com.cindy.movieapp.detail

import androidx.lifecycle.ViewModel
import com.cindy.movieapp.core.domain.model.Movie
import com.cindy.movieapp.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}