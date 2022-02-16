package com.ynovlyon.ymenu.presentation.dish_list

import android.graphics.Color
import android.provider.ContactsContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.Dish
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme
import com.ynovlyon.ymenu.ui.theme.Orange200
import kotlinx.coroutines.launch


@ExperimentalPagerApi

@Composable
fun DishList(navController: NavController) {
    val tabTitles =  DataProvider.categoryList
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val dishes = DataProvider.dishesList
    Column() {
        ScrollableTabRow(selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(
                        pagerState,
                        tabPositions,
                    )
                )
            }) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text =  { Text(title.name) })

            }
        }
        VerticalPager(
            state = pagerState,
            count = tabTitles.size,
        ) { tabIndex -> tabIndex
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
    }
}
