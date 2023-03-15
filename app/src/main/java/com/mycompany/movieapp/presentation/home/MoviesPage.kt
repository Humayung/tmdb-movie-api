package com.mycompany.movieapp.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.IMAGE_URL
import com.mycompany.movieapp.domain.movie.Movie

@Composable
fun MoviesPage(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onBottomReached: () -> Unit,
    onClick: (movieId: String) -> Unit
) {
    val listState = rememberLazyGridState()
    Box(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = listState
        ) {
            items(movies) {
                ImagePoster(
                    posterUrl = "$IMAGE_URL/${it.posterPath}",
                    modifier = Modifier
                        .clickable { onClick(it.id.toString()) })
            }
        }
    }
    // call the extension function
    listState.OnBottomReached {
        onBottomReached()
    }
}


@Composable
fun LazyGridState.OnBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) loadMore()
            }
    }
}