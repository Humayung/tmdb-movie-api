package com.mycompany.movieapp.presentation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("main_screen ")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}