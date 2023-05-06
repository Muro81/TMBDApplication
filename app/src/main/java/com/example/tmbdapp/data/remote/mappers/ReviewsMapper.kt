package com.example.tmbdapp.data.remote.mappers

import com.example.tmbdapp.data.remote.dto.ReviewsDto
import com.example.tmbdapp.domain.model.Review

fun ReviewsDto.toReviews() : List<Review> {
    val listResult = this.results
    val result = arrayListOf<Review>()
    listResult?.forEach { reviewDto ->
        result.add(
            Review(
                author = reviewDto.author ?: "",
                content = reviewDto.content ?: "",
                avatarPath = reviewDto.details?.avatarPath ?: "/xy44UvpbTgzs9kWmp4C3fEaCl5h.png",
                //default path because sometimes its null
                rating = reviewDto.details?.rating ?: 6.3f
            )
        )
    }
    return result.toList()
}