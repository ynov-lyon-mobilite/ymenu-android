package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.ynovlyon.ymenu.DishCategory
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider


@ExperimentalPagerApi

@Composable
fun DishList(navController: NavController) {
    val dishesCategory =  DataProvider.categoryList
    val dishes = DataProvider.dishesList
    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index}
    val listState = rememberLazyListState()
    LazyRow(
        modifier = Modifier
            .padding(start = 30.dp, top = 5.dp, end = 30.dp, bottom = 0.dp)
            .fillMaxSize()
            .fillMaxHeight()
    ){
        items(
            count = dishesCategory.size,
            itemContent = {
                index ->  DishCategory(dishCategory = dishesCategory[1] , index = index, selected = selectedIndex == index , onClick = onItemClick )
           }
        )
    }
    LazyColumn(
        state = listState,
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


