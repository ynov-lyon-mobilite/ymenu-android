package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.ListDishCategory
import com.ynovlyon.ymenu.NameCategoryHeader
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.DishCategory
import com.ynovlyon.ymenu.presentation.theme.YmenuOrangeAlt


@ExperimentalFoundationApi
@ExperimentalPagerApi

@Composable
fun DishList(navController: NavController, id: String?) {
    val dishesCategory =  DataProvider.categoryList
    val dishes = DataProvider.dishesList
    val restaurant = DataProvider.restaurantList
    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index}
    val listState = rememberLazyListState()

    if(id != null ){
        println(id)
    }

//    Column(
//        modifier = Modifier
//            .padding(start = 20.dp, top = 0.dp, end = 30.dp, bottom = 0.dp)
//    ) {
//        Text(
//            text =  restaurant[name].toString(),
//        )
//    }
    LazyRow(
        modifier = Modifier
            .padding(start = 30.dp, top = 5.dp, end = 30.dp, bottom = 0.dp)
            .fillMaxSize()
            .fillMaxHeight()
    ){
        items(
            count = dishesCategory.size,
            itemContent = {
                index ->  ListDishCategory(dishCategory = dishesCategory[index] , index = index, selected = selectedIndex == index , onClick = onItemClick )
           }
        )
    }
    LazyColumn(
        state = listState,
        modifier = Modifier
           .padding(start = 16.dp, top = 35.dp, end = 16.dp, bottom = 105.dp)
    )
    {
        val grouped = dishesCategory.groupBy { it.name[0]}
        grouped.forEach{ (name, dishesCategory)  ->
            stickyHeader {
                Text(
                    text = name.toString(),
                )
            }
            items(
                items = dishes,
                itemContent = {
                    DishListItem(dish = it, navController = navController)
                },
            );
        }
    }
}


