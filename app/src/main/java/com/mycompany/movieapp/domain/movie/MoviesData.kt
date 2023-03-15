package com.mycompany.movieapp.domain.movie

data class MoviesData(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)