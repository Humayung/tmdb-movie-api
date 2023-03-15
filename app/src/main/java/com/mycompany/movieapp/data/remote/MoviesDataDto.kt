package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json

data class MoviesDataDto(
    @field:Json(name = "page")
    val page: Int,

    @field:Json(name = "results")
    val results: List<MovieDto>,

    @field:Json(name = "total_pages")
    val totalPages: Int,

    @field:Json(name="total_results")
    val totalResults: Int

)
