package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json

data class ReviewsDataDto(
    @Json(name = "id")
    val id: Int,

    @Json(name = "page")
    val page: Int,

    @Json(name = "results")
    val results: List<ReviewDto>,

    @Json(name = "total_pages")
    val total_pages : Int,

    @Json(name = "total_results")
    val total_results : Int

)
