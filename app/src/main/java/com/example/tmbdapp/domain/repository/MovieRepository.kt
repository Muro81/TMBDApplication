package com.example.tmbdapp.domain.repository

import com.example.tmbdapp.core.utils.NetworkResponse
import com.example.tmbdapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularMovies(): Flow<NetworkResponse<List<Movie>>>
    suspend fun getNowPlayingMovies(): Flow<NetworkResponse<List<Movie>>>
    suspend fun getUpcomingMovies(): Flow<NetworkResponse<List<Movie>>>
    suspend fun getTopRatedMovies(): Flow<NetworkResponse<List<Movie>>>
    suspend fun getSearch(query : String) : Flow<NetworkResponse<List<Movie>>>
}