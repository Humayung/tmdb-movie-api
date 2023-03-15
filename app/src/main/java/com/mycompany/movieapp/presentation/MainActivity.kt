package com.mycompany.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.meditationuicompose.ui.theme.MovieAppTheme
import com.mycompany.movieapp.presentation.detail.DetailViewModel
import com.mycompany.movieapp.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Navigation(
                    homeViewModel = homeViewModel,
                    detailViewModel = detailViewModel
                )
            }
        }
    }
}
