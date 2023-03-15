package com.mycompany.movieapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.IMAGE_URL
import com.mycompany.movieapp.domain.movie.MovieDetail
import com.mycompany.movieapp.presentation.ui.theme.DeepBlue

@Composable
fun DetailScreenContent(movieDetail: MovieDetail) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize(),
    ) {
        Backdrop(
            backdropUrl = "$IMAGE_URL/${movieDetail.backdropPath}",
            modifier = Modifier
                .align(Alignment.TopStart)
        )
        Column(
            modifier = Modifier
                .padding(top = 150.dp)
                .padding(8.dp)

        ) {
            Poster(movieDetail = movieDetail)
            Spacer(modifier = Modifier.height(10.dp))
            ContentDetail(
                movieDetail = movieDetail
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}