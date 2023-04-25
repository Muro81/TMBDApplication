package com.example.tmbdapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("poster_path")
    val poster : String ? = null,
    val id : Int ? = null
)
