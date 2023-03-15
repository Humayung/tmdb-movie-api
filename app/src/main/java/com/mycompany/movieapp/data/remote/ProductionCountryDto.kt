package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json

data class ProductionCountryDto(
    @field:Json(name = "iso_3166_1")
    val iso31661: String,
    @field:Json(name = "name")
    val name: String
)