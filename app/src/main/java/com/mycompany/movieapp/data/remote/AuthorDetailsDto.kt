package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json

data class AuthorDetailsDto(
    @Json(name = "name")
    val name: String?,

    @Json(name = "username")
    val username: String?,

    @Json(name = "avatar_path")
    val avatar_path: String?,

    @Json(name = "rating")
    val rating: Float?
)