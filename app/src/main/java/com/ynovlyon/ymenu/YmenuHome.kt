package com.ynovlyon.ymenu.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.ynovlyon.ymenu.DishListItem
import com.ynovlyon.ymenu.data.DataProvider

@Composable
fun YmenuHome() {
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