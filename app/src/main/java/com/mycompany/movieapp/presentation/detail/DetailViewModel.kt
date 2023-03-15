package com.mycompany.movieapp.presentation.detail

import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.movieapp.domain.repository.MovieRepository
import com.mycompany.movieapp.domain.util.Resource
import com.mycompany.movieapp.presentation.home.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {
    var moviesDataState by mutableStateOf(DetailDataState())
    var reviewsDataState by mutableStateOf(ReviewsDataState())
    var selectedMovieId by mutableStateOf(-1)
    var lastRequest by mutableStateOf(Response())

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            lastRequest = lastRequest.copy(
                isLoading = true,
                error = null
            )
            when (val res = repository.getMovieById(
                movieId = movieId,
            )) {
                is Resource.Success -> {
                    lastRequest = lastRequest.copy(
                        isLoading = false,
                        error = res.message
                    )
                    moviesDataState = moviesDataState.copy(
                        movieDetail = res.data,
                    )
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

    fun fetchNextPage() {
        with(reviewsDataState) {
            val totalPages = totalPages
            val currentPage = page
            if (currentPage < totalPages) {
                val nextPage = currentPage + 1
                getReviewsByMovie(movieId = selectedMovieId, page = nextPage, append = true)
            }
        }
    }

    fun resetMovies() {
        reviewsDataState = ReviewsDataState()
    }

    fun getReviewsByMovie(movieId: Int, page: Int, append: Boolean = false) {
        viewModelScope.launch {
            lastRequest = lastRequest.copy(
                isLoading = true,
                error = null
            )
            when (val res = repository.getReviewsByMovie(
                movieId = movieId,
                page = page
            )) {
                is Resource.Success -> {
                    lastRequest = lastRequest.copy(
                        isLoading = false,
                        error = res.message
                    )
                    if (append) {
                        reviewsDataState = reviewsDataState.copy(
                            page = res.data!!.page,
                            results = listOf(reviewsDataState.results, res.data.results).flatten()
                        )
                    }
                    if (reviewsDataState.results.isEmpty() && !append) {
                        reviewsDataState = reviewsDataState.copy(
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

    @OptIn(ExperimentalMaterialApi::class)
    fun toggleBottomSheet(sheetState: BottomSheetState, scope: CoroutineScope) {
        scope.launch {
            if (sheetState.isCollapsed) {
                sheetState.expand()
            } else if (sheetState.isExpanded) {
                sheetState.collapse()
            }
        }
    }
}
