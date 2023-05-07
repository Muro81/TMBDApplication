package com.example.tmbdapp.core.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.tmbdapp.core.navigation.Routes.ROOT
import com.example.tmbdapp.core.navigation.Routes.SPLASH_SCREEN
import com.example.tmbdapp.core.navigation.destinations.*

infix fun NavGraphBuilder.rootNavGraph(
    navController: NavController
){
    navigation(
        route = ROOT,
        startDestination = SPLASH_SCREEN
    ){
        this homeScreenComposable navController
        this searchScreenComposable navController
        this watchListScreenComposable navController
        this detailsScreenComposable navController
        this splashScreenComposable navController
    }
}