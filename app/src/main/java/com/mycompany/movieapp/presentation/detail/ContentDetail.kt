package com.mycompany.movieapp.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mycompany.movieapp.domain.movie.MovieDetail

@Composable
fun ContentDetail(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Overview", style = MaterialTheme.typography.h2)
        StyledTextLineList(
            textItem = movieDetail.spokenLanguages.map { it.englishName ?: "" },
            prefix = "Spoken language: "
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = movieDetail.overview,
            style = MaterialTheme.typography.body1,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(10.dp))

        if (movieDetail.homepage.isNotEmpty()) Text(
            text = buildAnnotatedString {
                append("Homepage: ")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff64B5F6),
                    )
                ) {
                    append(movieDetail.homepage)
                }
            }
        )
    }
}