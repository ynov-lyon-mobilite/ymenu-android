package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.ScrollableTabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.ynovlyon.ymenu.DishCategory
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.DishCategory
import androidx.compose.material.Text as Text


@ExperimentalPagerApi

@Composable
fun DishList(navController: NavController) {
    val dishesCategory =  DataProvider.categoryList
    val dishes = DataProvider.dishesList
    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index}
    LazyRow(
        modifier = Modifier
            .padding(start = 30.dp, top = 5.dp, end = 30.dp, bottom = 0.dp)
            .fillMaxSize()
            .fillMaxHeight()
    ){
        items(
            count = dishesCategory.size,
            itemContent = {
                index ->  DishCategory(dishCategory = dishesCategory, index = index, selected = selectedIndex == index , onClick = onItemClick )
           }
        )
    }
    LazyColumn(
        modifier = Modifier
           .padding(start = 16.dp, top = 35.dp, end = 16.dp, bottom = 105.dp)
    ) {
        items(
            items = dishes,
            itemContent = {
                DishListItem(dish = it, navController = navController)
            },
        );
    }
}

