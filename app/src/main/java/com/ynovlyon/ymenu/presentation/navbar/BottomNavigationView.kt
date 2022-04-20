package com.ynovlyon.ymenu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPagerApi::class)
@ExperimentalPermissionsApi
@ExperimentalFoundationApi
@Composable
fun BottomNavigationView() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationHost(navController)
    }
}
