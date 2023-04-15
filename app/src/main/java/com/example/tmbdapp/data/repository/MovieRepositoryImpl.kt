package com.example.tmbdapp.data.repository

import com.example.tmbdapp.core.utils.NetworkResponse
import com.example.tmbdapp.data.remote.services.MovieApi
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    override suspend fun getMovie(query: String): Flow<NetworkResponse<Movie>> {
        TODO("Not yet implemented")
    }
}