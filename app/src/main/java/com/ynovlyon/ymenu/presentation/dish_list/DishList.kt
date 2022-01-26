package com.ynovlyon.ymenu.presentation.dish_list

import android.graphics.Color
import android.provider.ContactsContract
import android.util.Log
import android.util.Log.getStackTraceString
import android.util.Log.i
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.DataProvider.categoryList
import com.ynovlyon.ymenu.data.DishCategory
import android.util.Log.v as v1

@ExperimentalPagerApi

@Composable
fun DishList() {
    //val tabIndex = remember { mutableStateOf(0)}
    val tabTitles =  DataProvider.categoryList
    val pagerState = rememberPagerState()
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
                    onClick = { pagerState.targetPage
//                        i("cc", "add")
//                        getStackTraceString(pagerState.targetPage)
                    },
                    text =  { Text(title.name) })
            }
        }
        VerticalPager(
            state = pagerState,
            count = tabTitles.size,
        ) { tabIndex ->
            Text( tabIndex.toString(),
            modifier = Modifier 
                .fillMaxSize()
              // .background(Color.white)
            )
            
        }
    }
}



@Composable
fun CategoryList(selectedTabIndex: Int) {
    TabRow(selectedTabIndex = selectedTabIndex) {

    }
}