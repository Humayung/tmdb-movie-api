package com.mycompany.movieapp.presentation.home

import com.mycompany.movieapp.domain.movie.Movie

data class MoviesDataState(
    val page: Int = 0,
    val results: List<Movie> = listOf(),
    val totalPages: Int = 0,
    val totalResults: Int = 0,
)
