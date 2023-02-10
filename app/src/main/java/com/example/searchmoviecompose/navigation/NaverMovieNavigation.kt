package com.example.searchmoviecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.searchmoviecompose.ui.NaverMovieScreen
import com.example.searchmoviecompose.util.NavigationDestination

@Composable
fun NaverMovieNavigation(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = NaverMovieNavigation.route
) {

    NavHost(navController = navHostController, startDestination = startDestination) {
        naverMovieGraph()
    }
}

object NaverMovieNavigation : NavigationDestination {
    override val route: String = "naver_movie_route"
    override val destination: String = "naver_movie_destination"
}

fun NavGraphBuilder.naverMovieGraph() {
    composable(route = NaverMovieNavigation.route) {
        NaverMovieScreen()
    }
}