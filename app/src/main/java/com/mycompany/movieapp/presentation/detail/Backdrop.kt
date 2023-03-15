package com.mycompany.movieapp.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@SuppressLint("CheckResult")
@Composable
fun Backdrop(
    backdropUrl: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyImage(
            imageUrl = backdropUrl, modifier = Modifier

                .fillMaxWidth()
                .aspectRatio(16f / 9f, matchHeightConstraintsFirst = false)

        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f, matchHeightConstraintsFirst = false)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 100f
                    )
                )
        )
    }
}