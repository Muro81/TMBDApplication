package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.data.remote.dto.CreditsDto
import com.example.tmbdapp.domain.model.Cast

fun CreditsDto.toCast() : List<Cast>{
    val castList = this.cast
    val result = arrayListOf<Cast>()
    castList?.forEach { cast ->
        result.add(
            Cast(
                name = cast.name ?: "",
                picturePath = cast.picturePath ?: ""
            )
        )
    }

    return result.toList()
}