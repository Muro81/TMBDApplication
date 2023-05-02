package com.example.tmbdapp.data.remote.services

import com.example.tmbdapp.BuildConfig.API_KEY
import com.example.tmbdapp.data.remote.dto.MoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = API_KEY,
    ) : Response<MoviesDto>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesDto>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesDto>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesDto>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey : String = API_KEY,
        @Query("query") query : String
    ) : Response<MoviesDto>
}