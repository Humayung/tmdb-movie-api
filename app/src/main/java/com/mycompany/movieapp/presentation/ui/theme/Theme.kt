package com.example.meditationuicompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.mycompany.movieapp.presentation.ui.theme.Shapes
import com.mycompany.movieapp.presentation.ui.theme.Typography

@Composable
fun MovieAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}