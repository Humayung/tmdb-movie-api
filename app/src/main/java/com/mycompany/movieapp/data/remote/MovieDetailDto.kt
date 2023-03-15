package com.mycompany.movieapp.data.remote

import com.squareup.moshi.Json

data class MovieDetailDto(
    @field:Json(name = "backdrop_path")
    val backdropPath: String?,
    @field:Json(name = "genres")
    val genres: List<GenreDto>,
    @field:Json(name = "homepage")
    val homepage: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "popularity")
    val popularity: Double,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @field:Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDto>,
    @field:Json(name = "release_date")
    val releaseDate: String,
    @field:Json(name = "runtime")
    val runtime: Int?,
    @field:Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "vote_average")
    val voteAverage: Double,
    @field:Json(name = "vote_count")
    val voteCount: Int
)