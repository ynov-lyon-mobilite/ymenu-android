package com.ynovlyon.ymenu

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ynovlyon.ymenu.data.Dish
import com.ynovlyon.ymenu.presentation.onboarding.Greeting
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.presentation.dish_list.DishList

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun Menu() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "menu") {
        composable(route = "menu") {
            DishList(navController = navController)
        }
        composable(route = "details") {
            DetailsPlats(navController = navController)
        }
    }
}

@ExperimentalPermissionsApi
@Composable
fun QrCode() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "qrCode") {
        composable(route = "qrCode") {
            Camera(navController = navController)
        }
        composable(route = "menu") {
            DishList(navController = navController)
        }
    }
}

@Composable
fun Account(){
}

