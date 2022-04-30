package com.ynovlyon.ymenu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.connexion.LoginPage
import com.ynovlyon.ymenu.data.model.DishModel
import com.ynovlyon.ymenu.data.model.RestaurantModel
import com.ynovlyon.ymenu.presentation.dish_list.DishList
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems

@ExperimentalPagerApi
@ExperimentalPermissionsApi
@ExperimentalFoundationApi
@Composable
fun NavigationHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.QrCode.route
    ) {
        composable(
            BottomNavItems.Menu.route
        ) { backStackEntry ->

                val restaurant =
                    navController.previousBackStackEntry?.savedStateHandle?.get<RestaurantModel>("restaurant")
                val dishes =
                    navController.previousBackStackEntry?.savedStateHandle?.get<List<DishModel>>("dishes")
                if (dishes != null) {
                    if (restaurant != null) {
                        DishList(
                            dishes = dishes,
                            restaurant = restaurant,
                            navController = navController
                        )
                    }
                }

        }

        composable(BottomNavItems.QrCode.route) {
            Camera(navController = navController)
        }

        composable(BottomNavItems.Account.route) {
            LoginPage()
        }

        composable(
            "dishDetail"
        ) { backStackEntry ->
            val dish = navController.previousBackStackEntry?.savedStateHandle?.get<DishModel>("dish")
            if (dish != null) {
                DetailsPlats(navController = navController, dish = dish)
            }
        }
    }
}