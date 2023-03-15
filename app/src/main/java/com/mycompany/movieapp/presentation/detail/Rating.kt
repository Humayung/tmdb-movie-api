package com.mycompany.movieapp.presentation.detail

import RatingBars
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Rating(
    modifier: Modifier = Modifier,
    voteAverage: Float = 0f,
    voteCount: Int,
    voteMax: Int = 10,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${(voteAverage * 10).roundToInt() / 10f}", style = MaterialTheme.typography.h1)
        Spacer(modifier = modifier.width(5.dp))
        Column {
            RatingBars(stars = voteMax, rating = voteAverage)
            Text(text = "$voteCount voted", color = Color.LightGray)
        }
    }

}