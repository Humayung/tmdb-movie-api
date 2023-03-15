package com.mycompany.movieapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mycompany.movieapp.domain.genre.GenreType
import com.mycompany.movieapp.presentation.Screen
import com.mycompany.movieapp.presentation.ui.theme.DeepBlue
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        viewModel.selectedGenre.add(GenreType.Action)
        viewModel.getMoviesByGenres(page = 1)
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue),
        ) {
            Text(
                text = "Genres",
                modifier = Modifier.padding(horizontal = 8.dp),
                style = MaterialTheme.typography.h2
            )
            GenresSection(genres= GenreType.getAllGenres(), onClick = { genre ->
                viewModel.selectedGenre = genre
                viewModel.resetMovies()
                viewModel.getMoviesByGenres(1)
            })

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Total results: ${viewModel.moviesDataState.totalResults}",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            MoviesPage(movies = viewModel.moviesDataState.results,
                onBottomReached = { viewModel.fetchNextPage() }) {
                navController.navigate(Screen.DetailScreen.withArgs(it))
            }


            if (viewModel.lastRequest.isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            viewModel.lastRequest.error?.let {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(it)
                }
            }
        }
    }
}


