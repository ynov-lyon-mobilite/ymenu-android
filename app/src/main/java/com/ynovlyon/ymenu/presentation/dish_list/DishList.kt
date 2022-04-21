package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.*

@Composable
fun DishList(navController: NavController, id: String?) {
    val vm = DishListViewModel()
    LaunchedEffect(Unit, block = {
        if (id != null && id != "{id}") {
            vm.getDishList(id)
        }
    } )
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        items(vm.dishList) { dish ->
            DishListItem(dish = dish, navController = navController)
        }
    }
}