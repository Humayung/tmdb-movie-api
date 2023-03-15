package com.mycompany.movieapp.domain.review

data class ReviewsData(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val totalPages: Int,
    val totalResults: Int
)