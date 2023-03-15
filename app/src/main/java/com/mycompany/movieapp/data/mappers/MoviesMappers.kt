package com.mycompany.movieapp.data.mappers

import com.mycompany.movieapp.data.remote.MovieDto
import com.mycompany.movieapp.data.remote.MoviesDataDto
import com.mycompany.movieapp.domain.movie.Movie
import com.mycompany.movieapp.domain.movie.MoviesData

fun MoviesDataDto.toMoviesData(): MoviesData {
    return MoviesData(page = page,
        totalPages = totalPages,
        totalResults = totalResults,
        results = results.map { it.toMovie() })
}

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        popularity = popularity,
        voteAverage = voteAverage,
        voteCount = voteCount,
        adult = adult,
        video = video,
        genreIds = genreIds,
    )
}