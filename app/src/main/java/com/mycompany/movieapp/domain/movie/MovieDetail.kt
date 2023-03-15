package com.mycompany.movieapp.domain.movie

import com.mycompany.movieapp.domain.genre.Genre

data class MovieDetail(
    val posterPath: String?,
    val backdropPath: String?,
    val homepage: String,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val releaseDate: String,
    val runtime: Int?,
    val status: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
    val genres: List<Genre>,
    val productionCompanies: List<ProductionCompany>,
    val spokenLanguages: List<SpokenLanguage>
)