package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.core.utils.idToGenre
import com.example.tmbdapp.data.remote.dto.MoviesDto
import com.example.tmbdapp.domain.model.Movie
import kotlin.random.Random

fun MoviesDto.toMovies() : List<Movie> {
    val moviesDtoList = this.results
    val result = arrayListOf<Movie>()
    moviesDtoList?.forEach { movieDto ->
        if (movieDto.genres?.isEmpty() == false && movieDto.poster != null && movieDto.backdrop != null) {
            result.add(
                Movie(
                    poster = movieDto.poster,
                    id = movieDto.id ?: -1,
                    genre = movieDto.genres[0].idToGenre(),
                    date = movieDto.date ?: Random.nextInt(2000,2023).toString(),// ponekad ne dodju pa bolje da bude neki broj
                    overview = movieDto.overview ?: "",
                    title = movieDto.title ?: "",
                    runtime = movieDto.runtime ?: Random.nextInt(100, 180),// da ne bi za svaki radili poseban api poziv da
                    //dobijemo ovu informaciju, slucajno je generisemo
                    votes = movieDto.votes ?: (Random.nextFloat() * 10),// ne dodju uvijek rezultati
                    backdrop = movieDto.backdrop
                )
            )
        }
    }
    return result.toList()
}