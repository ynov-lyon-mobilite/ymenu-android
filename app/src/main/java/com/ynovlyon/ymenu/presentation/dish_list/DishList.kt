package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.ynovlyon.ymenu.DishCategory
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.DishCategory
import kotlinx.coroutines.launch
import androidx.compose.material.Text as Text


@ExperimentalPagerApi

@Composable
fun DishList(navController: NavController) {
    val dishesCategory =  DataProvider.categoryList
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val dishes = DataProvider.dishesList
    val title = dishesCategory[3].toString()
    LazyRow(
        modifier = Modifier
            .padding(start = 30.dp, top = 5.dp, end = 30.dp, bottom = 0.dp)
            .fillMaxSize()
            .fillMaxHeight()
    ){
        items(
            items = dishesCategory,
            itemContent = {
                DishCategory(dishCategory = it, navController = navController)
            },
        );

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
//    Column() {
//        ScrollableTabRow(selectedTabIndex = pagerState.currentPage,
//            indicator = { tabPositions ->
//                TabRowDefaults.Indicator(
//                    Modifier.pagerTabIndicatorOffset(
//                        pagerState,
//                        tabPositions,
//                    )
//                )
//            }) {
//            tabTitles.forEachIndexed { index, title ->
//                Tab(selected = pagerState.currentPage == index,
//                    onClick = {
//                        scope.launch {
//                            pagerState.animateScrollToPage(index)
//                        }
//                    },
//                    text =  { Text(title.name) })
//
//            }
//        }
//        VerticalPager(
//            state = pagerState,
//            count = tabTitles.size,
//        ) { tabIndex -> tabIndex
//            LazyColumn(
//                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//            ) {
//                items(
//                    items = dishes,
//                    itemContent = {
//                        DishListItem(dish = it, navController = navController)
//                    },
//                )
//            }
//        }
//    }
//}
