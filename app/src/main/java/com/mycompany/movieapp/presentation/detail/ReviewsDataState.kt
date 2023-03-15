package com.mycompany.movieapp.presentation.detail

import com.mycompany.movieapp.domain.review.Review

data class ReviewsDataState(
    val page: Int = 1,
    val results: List<Review> = listOf(),
    val totalPages: Int = 0,
    val totalResults: Int = 0
)