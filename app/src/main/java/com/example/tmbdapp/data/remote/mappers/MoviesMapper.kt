package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.data.remote.dto.MoviesDto
import com.example.tmbdapp.domain.model.Movie

fun MoviesDto.toMovies() : List<Movie>{
    val moviesDtoList = this.results
    val result = arrayListOf<Movie>()
    moviesDtoList?.forEach{ movieDto ->

        result.add(
            Movie(
                poster = movieDto.poster ?: "",
                id = movieDto.id ?: -1,
            )
        )
    }
    return result.toList()
}