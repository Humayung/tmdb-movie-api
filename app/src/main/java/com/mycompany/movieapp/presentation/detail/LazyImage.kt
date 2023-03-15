package com.mycompany.movieapp.presentation.detail

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@SuppressLint("CheckResult")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LazyImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val drw = CircularProgressDrawable(LocalContext.current)
    drw.setColorSchemeColors(Color.WHITE, Color.WHITE, Color.WHITE)
    drw.strokeWidth = 10f
    drw.centerRadius = 50f
    drw.start()
    GlideImage(
        model = imageUrl,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        requestBuilderTransform = { rb ->
            rb.placeholder(drw)
            rb
        }, modifier = modifier
    )
}