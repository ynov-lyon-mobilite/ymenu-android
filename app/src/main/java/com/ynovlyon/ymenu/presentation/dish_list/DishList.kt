package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ynovlyon.ymenu.*
import com.ynovlyon.ymenu.R
import com.ynovlyon.ymenu.data.model.DishModel
import com.ynovlyon.ymenu.data.model.RestaurantModel
import com.ynovlyon.ymenu.presentation.theme.YmenuOrangeAlt

@ExperimentalPagerApi
@Composable
fun DishList(navController: NavController, dishes: List<DishModel>, restaurant: RestaurantModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                actions = {
                    IconButton(
                        onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set("restaurant", restaurant)
                            navController.navigate("restaurantDetail")
                        },
                    ){
                        Icon(
                            Icons.Outlined.Storefront,
                            contentDescription = "Bouton du restaurant",
                            tint = YmenuOrangeAlt
                        )
                    }
                },
                title = {
                    Row {
                        Text(
                            text = restaurant.name.toString(),
                            style =
                                TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                        )
                    }
                })

        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.padding(bottom = 80.dp)
            ) {
                itemsIndexed(dishes) { index, dish ->
                    DishListItem(dish = dish) {
                        navController.currentBackStackEntry?.savedStateHandle?.set("dish", dish)
                        navController.navigate("dishDetail")
                    }
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 5.dp, vertical = 5.dp)
                            .fillMaxWidth(),
                        elevation = 2.dp,
                        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                    ) {}
                }

            }
        }
    )
}