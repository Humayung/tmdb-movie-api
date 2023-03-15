package com.mycompany.movieapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.domain.genre.GenreType
import com.mycompany.movieapp.presentation.ui.theme.ButtonBlue
import com.mycompany.movieapp.presentation.ui.theme.DarkerButtonBlue
import com.mycompany.movieapp.presentation.ui.theme.TextWhite

@Composable
fun GenresSection(
    genres: List<GenreType>, onClick: (selected: SnapshotStateList<GenreType>) -> Unit
) {
    val selectedGenre = remember {
        mutableStateListOf<GenreType>(GenreType.Action)
    }

    LazyRow {
        items(genres) { genre ->
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .padding(end = 0.dp)
                    .clickable {
                        if (selectedGenre.size > 1 && genre in selectedGenre) {
                            selectedGenre.remove(genre)
                            onClick(selectedGenre)
                            return@clickable
                        }
                        if (selectedGenre.size < 3) {
                            selectedGenre.add(genre)
                            onClick(selectedGenre)
                        }
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (genre in selectedGenre) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(8.dp)) {
                Text(text = genre.name, color = TextWhite)
            }
        }
    }
}