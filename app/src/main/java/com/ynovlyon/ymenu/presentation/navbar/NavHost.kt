package com.ynovlyon.ymenu

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems

@ExperimentalPermissionsApi
@ExperimentalFoundationApi
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.QrCode.route
    ) {
        composable(BottomNavItems.Menu.route, arguments = listOf(navArgument("id") { type = NavType.StringType;})
        ) {
            it.arguments?.getString("id")?.let {
                Menu(idRestaurant = it)
            }
        }

        composable(BottomNavItems.QrCode.route) {
            QrCode()
        }

        composable(BottomNavItems.Account.route) {
            Account()
        }
    }
}