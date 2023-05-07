package com.example.tmbdapp.core.navigation.destinations

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tmbdapp.core.navigation.Routes
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.presentation.watch.WatchListScreen

infix fun NavGraphBuilder.watchListScreenComposable(
    navController: NavController
){
    composable(route = Routes.WATCH_LIST_SCREEN) { navBackStackEntry ->
        val parentEntry = remember(navBackStackEntry) {
            navController.getBackStackEntry(Routes.ROOT)
        }
        val sharedViewModel = hiltViewModel<SharedViewModel>(parentEntry)
        WatchListScreen(
            viewModel = sharedViewModel,
            onArrowClicked = {navController.popBackStack()},
            getMovieDetails = {navController.navigate(route = Routes.DETAILS_SCREEN)}
        )
    }
}