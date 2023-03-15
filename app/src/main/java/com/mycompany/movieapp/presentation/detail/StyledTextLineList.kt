package com.mycompany.movieapp.presentation.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mycompany.movieapp.presentation.ui.theme.BlueViolet2

@Composable
fun StyledTextLineList(
    textItem: List<String>,
    color: Color = BlueViolet2,
    prefix: String = "",
    suffix: String = ""
) {

    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    textItem.ifEmpty {
        return@StyledTextLineList
    }


    Text(
        text = buildAnnotatedString {
            append(prefix)
            val lightStyle = SpanStyle(
                color = color, fontWeight = FontWeight.Bold
            )
            textItem.forEachIndexed { index, item ->
                pushStyle(lightStyle)
                item.let {
                    append(item)
                    pop()
                    if (index < textItem.size - 1) {
                        append(", ")
                    }
                }
            }
            append(suffix)
        },
        letterSpacing = letterSpacing,
        lineHeight = lineHeight
    )
}