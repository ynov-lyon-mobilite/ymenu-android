package com.ynovlyon.ymenu

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.data.Ingredients

@Composable
fun IngredientsListItem(ingredient: Ingredients, navController: NavController) {
    Text(
        text = ingredient.name,
        style = TextStyle(fontSize = 15.sp),
        modifier = Modifier
            .padding(7.dp)
    )
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .height(0.2.dp)
    )
}