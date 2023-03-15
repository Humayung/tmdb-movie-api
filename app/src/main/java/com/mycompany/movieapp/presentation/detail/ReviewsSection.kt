package com.mycompany.movieapp.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.domain.review.Review
import com.mycompany.movieapp.presentation.home.OnBottomReached
import com.mycompany.movieapp.presentation.ui.theme.DarkerButtonBlue
import com.mycompany.movieapp.presentation.ui.theme.DeepBlue

@Composable
fun ReviewsSection(
    modifier: Modifier = Modifier,
    reviews: List<Review>,
    onBottomReached: () -> Unit
) {
    val listState = rememberLazyListState()
    Surface(
        modifier = Modifier.fillMaxHeight(),
        color = DeepBlue
    ) {
        Box(modifier = modifier
            .fillMaxSize()
            .padding(16.dp)){
            LazyColumn (
                modifier = Modifier.fillMaxSize(),
                state = listState
            ){
                items(reviews) { review ->
                    ReviewItem(review = review)
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
    listState.OnBottomReached {
        onBottomReached()
    }
}

@Composable
fun LazyListState.OnBottomReached(
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