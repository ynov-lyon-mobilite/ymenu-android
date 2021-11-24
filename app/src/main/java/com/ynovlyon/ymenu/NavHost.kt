package com.ynovlyon.ymenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ynovlyon.ymenu.ui.theme.YMenuTheme

@ExperimentalFoundationApi
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.View1.route
    ) {
        composable(BottomNavItems.View1.route) {
            View1()
        }

        composable(BottomNavItems.View2.route) {
            View2()
        }

        composable(BottomNavItems.View3.route) {
            View3()
        }
    }
}