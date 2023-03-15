package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json
import java.time.LocalDateTime

data class ReviewDto(
    @Json(name = "author")
    val author: String?,

    @Json(name = "author_details")
    val author_details: AuthorDetailsDto?,

    @Json(name = "content")
    val content: String?,

    @Json(name = "created_at")
    val created_at: String?,

    @Json(name = "updated_at")
    val updated_at: String?,

    @Json(name = "id")
    val id: String?,

    )
