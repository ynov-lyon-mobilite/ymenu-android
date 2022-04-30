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
import com.ynovlyon.ymenu.presentation.theme.YmenuOrange
import com.ynovlyon.ymenu.presentation.theme.YmenuOrangeAlt
import com.ynovlyon.ymenu.ui.theme.Orange200

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
                colors = NavigationBarItemDefaults.colors(indicatorColor = YmenuOrangeAlt),
                icon = {
                    IconButton(
                        content = { Icon(painterResource(id = navItem.icon) , contentDescription = null) },
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                            }
                        },

                    )
                },
                enabled = true,
                onClick = {},
            )
        }
    }
}
