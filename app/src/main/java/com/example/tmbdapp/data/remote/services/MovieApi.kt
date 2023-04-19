package com.example.tmbdapp.data.remote.services

import com.example.tmbdapp.data.remote.dto.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("forecast.json")
    suspend fun getMovie(
        @Query("q") query : String,
        @Query("days") days: Int = 3
    ) : Response<MovieDto>
}