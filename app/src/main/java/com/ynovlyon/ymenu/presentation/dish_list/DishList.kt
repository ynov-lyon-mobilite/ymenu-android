package com.ynovlyon.ymenu.presentation.dish_list

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.*

@Composable
fun DishList(navController: NavController, id: String?, vm: DishListViewModel) {
    LaunchedEffect(Unit, block = {
        if (id != null) {
            vm.getDishList(id)
        }
    } )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(id.toString())
                    }
                })
        },
        content = {
            Column(modifier = Modifier.padding(16.dp)) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                ) {
                    items(vm.dishList) { dish ->
                        DishListItem(dish = dish, navController = navController)
                    }
                }
            }
        }
    )
}