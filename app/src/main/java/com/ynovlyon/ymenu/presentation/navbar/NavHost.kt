package com.ynovlyon.ymenu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems

@ExperimentalFoundationApi
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Menu.route
    ) {
        composable(BottomNavItems.Menu.route) {
            Menu()
        }

        composable(BottomNavItems.QrCode.route) {
            QrCode()
        }

        composable(BottomNavItems.Account.route) {
            Account()
        }
    }
}