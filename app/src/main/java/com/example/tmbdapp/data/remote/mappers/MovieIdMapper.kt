package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.data.remote.dto.MoviesDto

fun MoviesDto.toIds() : List<Int>{
    val result = arrayListOf<Int>()
    val moviesDtoList = this.results
    moviesDtoList?.forEach{ movieDto ->
        result.add( movieDto.id ?: -1 )
    }
    return result
}