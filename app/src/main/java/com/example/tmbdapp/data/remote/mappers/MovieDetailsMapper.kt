package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.data.remote.dto.MovieDetailsDto
import com.example.tmbdapp.domain.model.MovieDetails

fun MovieDetailsDto.toMovieDetails() : MovieDetails {
    return MovieDetails(
        votes = this.votes ?: -1f,
        title = this.title ?: "",
        runtime = this.runtime ?: -1,
        overview = this.overview ?: "",
        poster = this.poster ?: "",
        id = this.id ?: -1,
        date = this.date ?: "",
        genre = this.genres?.get(0)?.name ?: ""
    )
}