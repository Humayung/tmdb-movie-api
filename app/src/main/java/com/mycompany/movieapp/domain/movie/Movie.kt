package com.mycompany.movieapp.domain.movie

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String?,
    val releaseDate: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
    val adult: Boolean,
    val video: Boolean,
    val genreIds: List<Int>
)
