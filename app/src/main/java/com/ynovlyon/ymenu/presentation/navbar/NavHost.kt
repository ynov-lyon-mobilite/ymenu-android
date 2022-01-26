package com.ynovlyon.ymenu

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems

@ExperimentalPagerApi
@ExperimentalPermissionsApi
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