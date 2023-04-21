package com.example.tmbdapp.core.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.tmbdapp.core.navigation.Routes.HOME_SCREEN
import com.example.tmbdapp.core.navigation.Routes.ROOT
import com.example.tmbdapp.core.navigation.destinations.homeScreenComposable
import com.example.tmbdapp.core.navigation.destinations.searchScreenComposable
import com.example.tmbdapp.core.navigation.destinations.watchListScreenComposable

infix fun NavGraphBuilder.rootNavGraph(
    navController: NavController
){
    navigation(
        route = ROOT,
        startDestination = HOME_SCREEN
    ){
        this homeScreenComposable navController
        searchScreenComposable()
        watchListScreenComposable()
    }
}