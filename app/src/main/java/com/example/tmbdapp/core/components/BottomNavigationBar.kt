package com.example.tmbdapp.core.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tmbdapp.core.navigation.Screen
import com.example.tmbdapp.domain.model.BottomNavItem
import com.example.tmbdapp.ui.theme.Blue
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.TMDBAppTheme

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = Screen.HomeScreen.icon,
            text = Screen.HomeScreen.text
        ),
        BottomNavItem(
            route = Screen.SearchScreen.route,
            icon = Screen.SearchScreen.icon,
            text = Screen.SearchScreen.text
        ),
        BottomNavItem(
            route = Screen.WatchListScreen.route,
            icon = Screen.WatchListScreen.icon,
            text = Screen.WatchListScreen.text
        )
    )
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Gray2,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    onItemClick(item)
                },
                selectedContentColor = Blue,
                unselectedContentColor = LightGray,
                icon = {
                    if (item.icon != null)
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                },
                label = { Text(text = item.text) }
            )

        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    TMDBAppTheme {
        BottomNavigationBar(
            navController = rememberNavController(),
            onItemClick = {}
        )
    }
}