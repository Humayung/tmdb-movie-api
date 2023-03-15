package com.mycompany.movieapp.data.mappers

import com.mycompany.movieapp.data.remote.GenreDto
import com.mycompany.movieapp.data.remote.MovieDetailDto
import com.mycompany.movieapp.data.remote.ProductionCompanyDto
import com.mycompany.movieapp.data.remote.SpokenLanguageDto
import com.mycompany.movieapp.domain.genre.Genre
import com.mycompany.movieapp.domain.movie.MovieDetail
import com.mycompany.movieapp.domain.movie.ProductionCompany
import com.mycompany.movieapp.domain.movie.SpokenLanguage

fun MovieDetailDto.toMovieDetail(): MovieDetail {
    return MovieDetail(
        posterPath = posterPath,
        backdropPath = backdropPath,
        homepage = homepage,
        id = id,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        runtime = runtime,
        status = status,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
        genres = genres.toGenres(),
        productionCompanies = productionCompanies.toProductionCompanies(),
        spokenLanguages = spokenLanguages.toSpokenLanguages()
    )
}


private fun List<GenreDto>.toGenres(): List<Genre> {
    return map { genreDto ->
        Genre(
            id = genreDto.id,
            name = genreDto.name
        )
    }
}

private fun List<ProductionCompanyDto>.toProductionCompanies(): List<ProductionCompany> {
    return map { productionCompanyDto ->
        ProductionCompany(
            id = productionCompanyDto.id,
            logoPath = productionCompanyDto.logoPath,
            name = productionCompanyDto.name,
            originCountry = productionCompanyDto.originCountry
        )
    }
}


private fun List<SpokenLanguageDto>.toSpokenLanguages(): List<SpokenLanguage> {
    return map { spokenLanguageDto ->
        SpokenLanguage(
            englishName = spokenLanguageDto.english_name,
            iso6391 = spokenLanguageDto.iso_639_1,
            name = spokenLanguageDto.name
        )
    }
}
