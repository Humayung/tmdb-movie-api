import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mycompany.movieapp.R
import com.mycompany.movieapp.presentation.ui.theme.BlueViolet2
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun RatingBars(
    modifier: Modifier = Modifier,
    rating: Float = 0f,
    stars: Int = 5,
    starsColor: Color = BlueViolet2,
    starSize: Dp = 16.dp
) {
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_24),
                contentDescription = null,
                tint = starsColor,
                modifier = modifier.size(starSize)
            )
        }
        if (halfStar) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_half_24),
                contentDescription = null,
                tint = starsColor,
                modifier = modifier.size(starSize)
            )
        }
        repeat(unfilledStars) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_outline_24),
                contentDescription = null,
                tint = starsColor,
                modifier = modifier.size(starSize)
            )
        }
    }
}