package com.mycompany.movieapp.presentation.detail

import RatingBars
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mycompany.movieapp.IMAGE_URL
import com.mycompany.movieapp.domain.review.Review
import com.mycompany.movieapp.presentation.ui.theme.BlueViolet2

@Composable
fun ReviewItem(
    modifier: Modifier = Modifier,
    review: Review
) {
    Row(modifier = modifier) {
        LazyImage(
            imageUrl = "$IMAGE_URL/${review.authorDetails!!.avatarPath}",
            modifier = Modifier
                .size(56.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .clip(RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = review.author!!, fontWeight = FontWeight.Bold)
            Text(text = "${review.authorDetails.rating.toString()} / 10", color = BlueViolet2)
            review.authorDetails.rating?.let { RatingBars(stars = 10, rating = it, starSize = 12.dp) }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = review.content!!,
                style = MaterialTheme.typography.body1,
                lineHeight = 20.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}
