package com.mycompany.movieapp.presentation.detail

import RatingBars
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.domain.genre.Genre
import com.mycompany.movieapp.domain.movie.ProductionCompany

@Composable
fun BriefMovieAttribute(
    title: String,
    productionCompanies: List<ProductionCompany>,
    genres : List<Genre>,
    voteAverage: String,
    voteCount: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(10.dp))
        Rating(voteCount = voteCount.toInt(), voteAverage = voteAverage.toFloat())
        GenresTag(genres = genres)
        Spacer(modifier = Modifier.height(10.dp))
        StyledTextLineList(
            textItem = productionCompanies.map { it.name ?: "" },
            prefix = "By "
        )
    }
}