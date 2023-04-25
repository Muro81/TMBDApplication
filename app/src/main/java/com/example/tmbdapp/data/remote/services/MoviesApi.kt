package com.example.tmbdapp.data.remote.services

import com.example.tmbdapp.BuildConfig.API_KEY
import com.example.tmbdapp.data.remote.dto.MovieDetailsDto
import com.example.tmbdapp.data.remote.dto.MoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

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

    @GET("movie/")
    suspend fun getMovieDetails(
        @Url url : Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MovieDetailsDto>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey : String = API_KEY,
        @Query("query") query : String
    ) : Response<MoviesDto>
}