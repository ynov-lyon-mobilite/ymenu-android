package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ynovlyon.ymenu.*
import com.ynovlyon.ymenu.data.model.DishModel
import com.ynovlyon.ymenu.data.model.RestaurantModel

@ExperimentalPagerApi
@Composable
fun DishList(navController: NavController, dishes: List<DishModel>, restaurant: RestaurantModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Row {
                        Text(restaurant.name.toString())
                    }
                })
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            ) {
                itemsIndexed(dishes) { index, dish ->
                    DishListItem(dish = dish, navController = navController) {
                        navController.currentBackStackEntry?.savedStateHandle?.set("dish", dish)
                        navController.navigate("dishDetail")
                    }
                }
            }
        }
    )
}