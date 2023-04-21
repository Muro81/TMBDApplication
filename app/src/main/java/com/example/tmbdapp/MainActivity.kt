package com.example.tmbdapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.tmbdapp.core.components.BottomNavigationBar
import com.example.tmbdapp.core.navigation.graphs.TMDBAppNavigation
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.ui.theme.TMDBAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var shouldShowBottomBar by remember {
                mutableStateOf(true)
            }
            TMDBAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            visible = shouldShowBottomBar,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            BottomNavigationBar(
                                navController = navController,
                                onItemClick = { navItem ->
                                    navController.navigate(navItem.route) {
                                        popUpTo(route = navItem.route) {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    println("Inner padding is $innerPadding")
                    TMDBAppNavigation(navController = navController)
                }
            }
        }
    }
}