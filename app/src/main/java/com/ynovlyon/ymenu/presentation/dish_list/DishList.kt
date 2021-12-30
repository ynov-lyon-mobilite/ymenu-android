package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider

@Composable
fun DishList() {
    val dishes = remember { DataProvider.dishesList }
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
enum class TabPage

@Composable
fun CategoryList(selectedTabIndex: Int) {
    TabRow(selectedTabIndex = selectedTabIndex) {

    }
}