package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.core.utils.idToGenre
import com.example.tmbdapp.data.remote.dto.MoviesDto
import com.example.tmbdapp.domain.model.Movie
import kotlin.random.Random

fun MoviesDto.toMovies() : List<Movie>{
    val moviesDtoList = this.results
    val result = arrayListOf<Movie>()
    moviesDtoList?.forEach{ movieDto ->
        val genre = movieDto.genres?.get(0)?.idToGenre()
        result.add(
            Movie(
                poster = movieDto.poster ?: "",
                id = movieDto.id ?: -1,
                genre = genre ?: "",
                date = movieDto.date ?: "",
                overview = movieDto.overview ?: "",
                title = movieDto.title ?: "",
                runtime = movieDto.runtime ?: Random.nextInt(100,180),
                votes = movieDto.votes ?: -1f
            )
        )
    }
    return result.toList()
}