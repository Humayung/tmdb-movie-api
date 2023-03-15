package com.mycompany.movieapp.domain.repository

import com.mycompany.movieapp.domain.movie.MovieDetail
import com.mycompany.movieapp.domain.movie.MoviesData
import com.mycompany.movieapp.domain.review.ReviewsData
import com.mycompany.movieapp.domain.util.Resource

interface MovieRepository {
    suspend fun getMoviesByGenre(genres: List<Int>, page: Int): Resource<MoviesData>
    suspend fun getMovieById(movieId: Int): Resource<MovieDetail>
    suspend fun getReviewsByMovie(movieId: Int, page: Int) : Resource<ReviewsData>
}