package com.mycompany.movieapp.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.movieapp.domain.genre.GenreType
import com.mycompany.movieapp.domain.repository.MovieRepository
import com.mycompany.movieapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {

    var selectedGenre = mutableStateListOf<GenreType>()
    var moviesDataState by mutableStateOf(MoviesDataState())
    var lastRequest by mutableStateOf(Response())


    fun fetchNextPage() {
        with(moviesDataState) {
            val totalPages = totalPages
            val currentPage = page
            if (currentPage < totalPages) {
                val nextPage = currentPage + 1
                getMoviesByGenres(page = nextPage, append = true)
            }
        }
    }


    fun resetMovies() {
        moviesDataState = MoviesDataState()
    }

    fun getMoviesByGenres(page: Int, append: Boolean = false) {
        viewModelScope.launch {
            lastRequest = lastRequest.copy(
                isLoading = true,
                error = null
            )
            when (val res = repository.getMoviesByGenre(
                genres = selectedGenre.map { it.id },
                page = page
            )) {
                is Resource.Success -> {
                    lastRequest = lastRequest.copy(
                        isLoading = false,
                        error = res.message
                    )
                    if (append) {
                        moviesDataState = moviesDataState.copy(
                            page = res.data!!.page,
                            results = listOf(moviesDataState.results, res.data.results).flatten()
                        )
                    }
                    if (moviesDataState.results.isEmpty() && !append) {
                        moviesDataState = moviesDataState.copy(
                            page = res.data!!.page,
                            totalResults = res.data.totalResults,
                            totalPages = res.data.totalPages,
                            results = res.data.results
                        )
                    }
                }
                is Resource.Error -> {
                    lastRequest = lastRequest.copy(
                        isLoading = false,
                        error = res.message
                    )
                }
            }
        }
    }
}