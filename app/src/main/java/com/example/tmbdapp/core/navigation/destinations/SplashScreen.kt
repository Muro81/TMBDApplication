package com.example.tmbdapp.core.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tmbdapp.core.navigation.Routes
import com.example.tmbdapp.presentation.splash.SplashScreen

infix fun NavGraphBuilder.splashScreenComposable(
    navController: NavController
){
    composable(route = Routes.SPLASH_SCREEN) {
        SplashScreen(
            goHome = {
                navController.popBackStack()
                navController.navigate(route = Routes.HOME_SCREEN)
            }
        )
    }
}