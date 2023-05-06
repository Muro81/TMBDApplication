package com.example.tmbdapp.core.navigation

import com.example.tmbdapp.R
import com.example.tmbdapp.core.navigation.Routes.DETAILS_SCREEN
import com.example.tmbdapp.core.navigation.Routes.HOME_SCREEN
import com.example.tmbdapp.core.navigation.Routes.SEARCH_SCREEN
import com.example.tmbdapp.core.navigation.Routes.WATCH_LIST_SCREEN

sealed class Screen(val route: String, val icon: Int? = null, val text : String) {
    object HomeScreen: Screen(route = HOME_SCREEN, icon = R.drawable.home_ic, text = "Home")
    object SearchScreen: Screen(route = SEARCH_SCREEN, icon = R.drawable.search_ic, text = "Search")
    object WatchListScreen: Screen(route = WATCH_LIST_SCREEN, icon = R.drawable.watch_list_ic, text = "Watch list")
}