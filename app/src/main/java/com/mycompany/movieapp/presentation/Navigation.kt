package com.mycompany.movieapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mycompany.movieapp.presentation.detail.DetailScreen
import com.mycompany.movieapp.presentation.detail.DetailViewModel
import com.mycompany.movieapp.presentation.home.HomeScreen
import com.mycompany.movieapp.presentation.home.HomeViewModel

@Composable
fun Navigation(homeViewModel: HomeViewModel, detailViewModel: DetailViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(viewModel = homeViewModel, navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.StringType
                    nullable = false
                }
            ))
        { entry ->
            DetailScreen(
                viewModel = detailViewModel,
                navController = navController,
                movieId = entry.arguments?.getString("movieId")!!
            )
        }
    }
}