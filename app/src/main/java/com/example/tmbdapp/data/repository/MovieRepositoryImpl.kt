package com.example.tmbdapp.data.repository

import com.example.tmbdapp.core.utils.NetworkResponse
import com.example.tmbdapp.data.remote.mappers.toCast
import com.example.tmbdapp.data.remote.mappers.toMovies
import com.example.tmbdapp.data.remote.mappers.toReviews
import com.example.tmbdapp.data.remote.services.MoviesApi
import com.example.tmbdapp.domain.model.Cast
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.domain.model.Review
import com.example.tmbdapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : MovieRepository {
    override suspend fun getPopularMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.getPopularMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }

    override suspend fun getNowPlayingMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.getNowPlayingMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }

    override suspend fun getUpcomingMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.getUpcomingMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }

    override suspend fun getTopRatedMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.getTopRatedMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }

    override suspend fun getSearch(query : String): Flow<NetworkResponse<List<Movie>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.searchMovies(query = query)
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies  = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }

    override suspend fun getReviews(id: Int): Flow<NetworkResponse<List<Review>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.getReviews(id)
                val reviewsDto = response.body()
                if(response.isSuccessful && response.body() != null){
                    val reviews = reviewsDto?.toReviews()
                    emit(NetworkResponse.Success(data = reviews))
                }else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
            }
        }

    override suspend fun getCast(id: Int): Flow<NetworkResponse<List<Cast>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = moviesApi.getCast(id)
                val creditsDto = response.body()
                if(response.isSuccessful && response.body() != null){
                    val cast = creditsDto?.toCast()
                    emit(NetworkResponse.Success(data = cast))
                }else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }
    }

