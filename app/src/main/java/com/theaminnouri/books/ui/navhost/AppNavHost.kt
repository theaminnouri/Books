package com.theaminnouri.books.ui.navhost

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.theaminnouri.presentation_search.SearchScreen


@Composable
fun AppNavHost(navController: NavHostController) = NavHost(
    navController = navController,
    startDestination = "search"
) {
    composable(route = "search") {
        SearchScreen(viewModel = hiltViewModel(), navController = navController)
    }
}
