package com.example.tmbdapp.domain.repository

import com.example.tmbdapp.core.utils.NetworkResponse
import com.example.tmbdapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovie(query : String): Flow<NetworkResponse<Movie>>
}