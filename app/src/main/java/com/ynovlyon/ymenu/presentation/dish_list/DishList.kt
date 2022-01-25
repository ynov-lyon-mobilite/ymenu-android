package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.DataProvider.categoryList
import com.ynovlyon.ymenu.data.DishCategory

@ExperimentalPagerApi
@Composable
fun DishList() {
    val dishes = remember { DataProvider.dishesList }
//    val pagerState = rememberPagerState(
//        pageCount = categoryList.size,
//        initialOffscreenLimit = 2,
//        initialPage = 0,
//        infiniteLoop = false
//    )
//        TabRow(
//            selectedTabIndex = pagerState.currentPage,
//            indicator = { tabPosition ->
//                TabRowDefaults.Indicator(
//                    Modifier.pagerTabIndicatorOffset(pagerState, tabPosition)
//                )
//            }
//        ) {  pages.forEachIndexed { index, title ->
//                Tab(
//                    text = { Text(title) },
//                    selected = pagerState.currentPage == index,
//                    onclick = {}
//                )
//            }
//        }
//
//    HorizontalPager(
//        count = pages.size,
//        state = pagerState,
//    ) { page ->
//
//    }


    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        items(
            items = dishes,
            itemContent = {
                DishListItem(dish = it)
            }
        )
    }
}



@Composable
fun CategoryList(selectedTabIndex: Int) {
    TabRow(selectedTabIndex = selectedTabIndex) {

    }
}