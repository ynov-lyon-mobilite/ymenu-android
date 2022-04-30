package com.ynovlyon.ymenu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.data.model.DishModel
import com.ynovlyon.ymenu.data.model.RestaurantModel
import com.ynovlyon.ymenu.presentation.dish_list.DishList
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems
import com.ynovlyon.ymenu.presentation.restaurant_detail.DetailRestaurant

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
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(alignment = Alignment.Center),
                    text = "Bientôt disponible!", style =
                    TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }

        }

        composable(
            "dishDetail"
        ) { backStackEntry ->
            val dish = navController.previousBackStackEntry?.savedStateHandle?.get<DishModel>("dish")
            if (dish != null) {
                DetailsPlats(navController = navController, dish = dish)
            }
        }

        composable(
            "restaurantDetail"
        ) {
            val restaurant = navController.previousBackStackEntry?.savedStateHandle?.get<RestaurantModel>("restaurant")
            if (restaurant != null) {
                DetailRestaurant(navController = navController, restaurant = restaurant)
            }
        }
    }
}
