package com.example.tmbdapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailsDto(
    val id : Int ? = null,
    val title : String ? = null,
    @SerializedName("poster_path")
    val poster : String ? = null,
    @SerializedName("vote_average")
    val votes : Float ? = null,
    val genres : List<GenresDto> ? = null,
    @SerializedName("release_date")
    val date : String ? = null,
    val runtime : Int ? = null,
    val overview : String ? = null
)
