package com.cindy.movieapp.core.data.remote.network

import com.cindy.movieapp.core.data.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
    ): ListMovieResponse
}