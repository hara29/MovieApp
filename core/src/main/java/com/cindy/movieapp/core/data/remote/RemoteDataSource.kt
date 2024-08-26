package com.cindy.movieapp.core.data.remote

import com.cindy.movieapp.core.BuildConfig
import android.util.Log
import com.cindy.movieapp.core.data.remote.network.ApiResponse
import com.cindy.movieapp.core.data.remote.network.ApiService
import com.cindy.movieapp.core.data.remote.response.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getAllMovie(): Flow<ApiResponse<List<ResultsItem>>> {

        return flow {
            try {
                val response = apiService.getMovies(apiKey)
                val dataArray = response.movies
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.movies))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }
}