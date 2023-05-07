package com.example.tmbdapp.core.navigation.destinations

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tmbdapp.core.navigation.Routes.DETAILS_SCREEN
import com.example.tmbdapp.core.navigation.Routes.HOME_SCREEN
import com.example.tmbdapp.core.navigation.Routes.ROOT
import com.example.tmbdapp.core.navigation.Routes.SEARCH_SCREEN
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.presentation.home.HomeScreen

infix fun NavGraphBuilder.homeScreenComposable(
    navController: NavController
) {
    composable(route = HOME_SCREEN) { navBackStackEntry ->
        val parentEntry = remember(navBackStackEntry) {
            navController.getBackStackEntry(ROOT)
        }
        val sharedViewModel = hiltViewModel<SharedViewModel>(parentEntry)
        HomeScreen(
            viewModel = sharedViewModel,
            toSearchScreen = { navController.navigate(route = SEARCH_SCREEN) },
            getMovieDetails = {navController.navigate(route = DETAILS_SCREEN)}
        )
    }
}