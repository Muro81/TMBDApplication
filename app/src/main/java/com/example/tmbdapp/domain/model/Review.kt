package com.example.tmbdapp.domain.model

data class Review(
    val author : String,
    val avatarPath : String,
    val rating : Float,
    val content : String
)
