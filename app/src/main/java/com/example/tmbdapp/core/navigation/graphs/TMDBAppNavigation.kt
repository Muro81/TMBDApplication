package com.example.tmbdapp.core.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tmbdapp.core.navigation.Routes.ROOT

@Composable
fun TMDBAppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ROOT
    ) {
        this rootNavGraph navController
    }
}