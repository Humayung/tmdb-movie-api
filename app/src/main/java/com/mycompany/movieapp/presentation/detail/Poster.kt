package com.mycompany.movieapp.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.mycompany.movieapp.IMAGE_URL
import com.mycompany.movieapp.domain.movie.MovieDetail

@SuppressLint("CheckResult")
@Composable
fun Poster(
    movieDetail: MovieDetail,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            LazyImage(
                imageUrl = "$IMAGE_URL/${movieDetail.posterPath}",
                Modifier
                    .width(150.dp)
                    .aspectRatio(9f / 16f, matchHeightConstraintsFirst = false)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(10.dp))
            BriefMovieAttribute(
                title = movieDetail.title,
                voteAverage = movieDetail.voteAverage.toString(),
                voteCount = movieDetail.voteCount.toString(),
                productionCompanies = movieDetail.productionCompanies,
                genres = movieDetail.genres
            )
        }
    }
}