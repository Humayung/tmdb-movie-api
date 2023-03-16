package com.mycompany.movieapp.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mycompany.movieapp.presentation.ui.theme.DeepBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("CheckResult")
@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    navController: NavHostController,
    movieId: String?
) {
    LaunchedEffect(key1 = movieId) {
        movieId?.toInt()?.let {
            viewModel.resetMovies()
            viewModel.selectedMovieId = it
            viewModel.getMovieById(movieId = it)
            viewModel.getReviewsByMovie(movieId = it, page = 1)
        }

    }
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val sheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
    ) {
        BottomSheetScaffold(
            scaffoldState = sheetScaffoldState,
            sheetElevation = 20.dp,
            drawerElevation = 20.dp,
            sheetBackgroundColor = Color.Transparent,
            sheetPeekHeight = 100.dp,
            content = {
                viewModel.moviesDataState.movieDetail?.let { it1 ->
                    DetailScreenContent(movieDetail = it1)
                }
            },
            sheetContent = {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.background(DeepBlue)
                ) {
                    BottomSheetAnchor(
                        onClick = { viewModel.toggleBottomSheet(sheetState, scope) },
                        sheetState = sheetState
                    )
                    Text(
                        text = "Reviews (${viewModel.reviewsDataState.totalResults})",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(10.dp)
                    )
                    ReviewsSection(
                        reviews = viewModel.reviewsDataState.results,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        viewModel.fetchNextPage()
                    }
                }
            }
        )
        viewModel.lastRequest.error?.let {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(it)
            }
        }
    }

}