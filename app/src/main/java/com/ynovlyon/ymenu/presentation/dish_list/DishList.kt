package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ynovlyon.ymenu.*
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.Restaurant
import com.ynovlyon.ymenu.presentation.navbar.BottomNavItems

@Composable
fun DishList(navController: NavController, idRestaurant: String?) {
    val dishes = remember { DataProvider.dishesList }
    if (idRestaurant != null) {
        println("oui")
    }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        items(
            items = dishes,
            itemContent = {
                DishListItem(dish = it, navController = navController)
            },


        )
    }
}
enum class TabPage

@Composable
fun CategoryList(selectedTabIndex: Int) {
    TabRow(selectedTabIndex = selectedTabIndex) {

    }
}