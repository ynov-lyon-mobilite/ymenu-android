package com.ynovlyon.ymenu

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ynovlyon.ymenu.data.Dish
import com.ynovlyon.ymenu.presentation.onboarding.Greeting
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.presentation.dish_list.DishList

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@ExperimentalPagerApi
@Composable
fun Menu(id: String?) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "menu") {
        composable(route = "menu") {
            DishList(navController = navController, id = id)
        }
        composable(route = "details") {
            DetailsPlats(navController = navController)
        }
    }
}
@ExperimentalPermissionsApi
@Composable
fun QrCode(navController: NavHostController) {
    Camera(navController = navController)
}

@Composable
fun Account() {
}

