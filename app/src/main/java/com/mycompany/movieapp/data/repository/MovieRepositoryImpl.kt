package com.mycompany.movieapp.data.repository

import com.mycompany.movieapp.data.mappers.toMovieDetail
import com.mycompany.movieapp.data.mappers.toMoviesData
import com.mycompany.movieapp.data.mappers.toReviewsData
import com.mycompany.movieapp.data.remote.MovieApi
import com.mycompany.movieapp.domain.movie.MovieDetail
import com.mycompany.movieapp.domain.movie.MoviesData
import com.mycompany.movieapp.domain.repository.MovieRepository
import com.mycompany.movieapp.domain.review.ReviewsData
import com.mycompany.movieapp.domain.util.Resource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getMoviesByGenre(genres: List<Int>, page: Int): Resource<MoviesData> {
        return try {
            Resource.Success(
                data = api.getMoviesByGenre(
                    genreId = genres,
                    page = page
                ).toMoviesData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    override suspend fun getMovieById(movieId: Int): Resource<MovieDetail> {
        return try {
            Resource.Success(
                data = api.getMovieById(
                    movieId = movieId
                ).toMovieDetail()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    override suspend fun getReviewsByMovie(movieId: Int, page: Int): Resource<ReviewsData> {
        return try {
            Resource.Success(
                data = api.getReviewsByMovie(
                    movieId = movieId,
                    page = page
                ).toReviewsData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }


}