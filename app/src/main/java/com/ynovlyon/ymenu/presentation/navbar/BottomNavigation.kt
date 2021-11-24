package com.ynovlyon.ymenu

import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems
import com.ynovlyon.ymenu.presentation.navbar.navItems

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomNavItems> = navItems,
) {

    NavigationBar {

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination
        items.forEach { navItem ->

            NavigationBarItem(
                selected = currentRoute?.hierarchy?.any {
                    navItem.route == it.route
                } == true,
                modifier = Modifier.background(color = Color.White),
                icon = {
                    IconButton(
                        content = { Icon(painterResource(id = navItem.icon) , contentDescription = null ) },
                        onClick = {
                            navController.navigate(navItem.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                            }
                        },

                    )
                },
                enabled = false,
                onClick = {},
            )
        }
    }
}
