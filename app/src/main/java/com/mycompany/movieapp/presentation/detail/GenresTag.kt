package com.mycompany.movieapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.domain.genre.Genre
import com.mycompany.movieapp.presentation.ui.theme.DarkerButtonBlue
import com.mycompany.movieapp.presentation.ui.theme.TextWhite

@Composable
fun GenresTag(
    genres: List<Genre>
) {
    LazyRow {
        items(genres) { genre ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        DarkerButtonBlue
                    )
                    .padding(5.dp)
            ) {
                Text(text = genre.name, color = TextWhite)
            }
        }
    }
}