package com.cindy.movieapp.core.utils

import com.cindy.movieapp.core.data.local.entity.MovieEntity
import com.cindy.movieapp.core.data.remote.response.ResultsItem
import com.cindy.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItem>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                id = it.id,
                title = it.title,
                voteCount = it.voteCount,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                id = it.id,
                title = it.title,
                voteCount = it.voteCount,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        overview = input.overview,
        originalLanguage = input.originalLanguage,
        releaseDate = input.releaseDate,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        id = input.id,
        title = input.title,
        voteCount = input.voteCount,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        isFavorite = input.isFavorite
    )
}