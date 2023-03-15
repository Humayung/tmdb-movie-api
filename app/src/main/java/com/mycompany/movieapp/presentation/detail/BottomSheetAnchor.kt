package com.mycompany.movieapp.presentation.detail

import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetAnchor(
    onClick: () -> Unit,
    sheetState: BottomSheetState
) {
    IconButton(onClick = {
        onClick()
    }) {
        val icon = if (sheetState.isExpanded) {
            Icons.Filled.KeyboardArrowDown
        } else {
            Icons.Filled.KeyboardArrowUp
        }

        Icon(
            imageVector = icon,
            contentDescription = "Icon button",
            tint = Color.White
        )
    }
}