package com.mycompany.movieapp.presentation.home

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@SuppressLint("CheckResult")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImagePoster(
    modifier: Modifier = Modifier,
    posterUrl: String,
) {
    val drw = CircularProgressDrawable(LocalContext.current)
    drw.setColorSchemeColors(Color.WHITE, Color.WHITE, Color.WHITE)
    drw.strokeWidth = 10f
    drw.centerRadius = 50f
    drw.start()
    Box(
        modifier = modifier
            .aspectRatio(9f / 16f, matchHeightConstraintsFirst = true)
            .padding(8.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        GlideImage(
            model = posterUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            requestBuilderTransform = {
                it.placeholder(drw)
                it
            }
        )


    }
}