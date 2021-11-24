package com.ynovlyon.ymenu

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ynovlyon.ymenu.ui.theme.YMenuTheme
import com.ynovlyon.ymenu.ui.theme.YmenuOrange
import com.ynovlyon.ymenu.ui.theme.YmenuRed

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
