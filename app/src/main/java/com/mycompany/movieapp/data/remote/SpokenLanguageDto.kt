package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json


data class SpokenLanguageDto(
    @Json(name = "english_name")
    val english_name: String?,

    @Json(name = "iso_639_1")
    val iso_639_1: String?,

    @Json(name = "name")
    val name: String?
)