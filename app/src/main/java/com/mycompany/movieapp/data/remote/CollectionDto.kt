package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json

data class CollectionDto(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "backdrop_path")
    val backdropPath: String?
)