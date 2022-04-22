package com.ynovlyon.ymenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.presentation.dish_list.DishList
import com.ynovlyon.ymenu.presentation.dish_list.DishListViewModel

@ExperimentalPagerApi
@Composable
fun Menu(id: String?, name: String?) {
    val navController = rememberNavController()
    val vm = DishListViewModel()
    NavHost(navController, startDestination = "menu") {
        composable(route = "menu") {
            DishList(navController = navController, id = id, vm = vm)
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

