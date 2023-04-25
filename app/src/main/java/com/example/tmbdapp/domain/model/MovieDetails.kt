package com.example.tmbdapp.domain.model

data class MovieDetails(
    val id : Int,
    val title : String,
    val poster : String,
    val votes : Float,
    val genre : String,
    val date : String,
    val runtime : Int,
    val overview : String
)

