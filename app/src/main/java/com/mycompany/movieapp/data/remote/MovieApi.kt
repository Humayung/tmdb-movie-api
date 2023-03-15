package com.mycompany.movieapp.data.remote

import com.mycompany.movieapp.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("3/discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: List<Int>,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("sort_by") sortBy: String = "popularity.desc",
    ): MoviesDataDto

    @GET("3/movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ): MovieDetailDto

    @GET("3/movie/{movie_id}/reviews")
    suspend fun getReviewsByMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
    ): ReviewsDataDto


}