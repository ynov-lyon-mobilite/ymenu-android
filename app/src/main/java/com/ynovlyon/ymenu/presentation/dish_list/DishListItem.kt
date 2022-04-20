package com.ynovlyon.ymenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.data.Dish


@Composable
fun DishListItem(dish: Dish, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    navController.navigate("details") {
                        popUpTo("menu") { inclusive = true }
                    }
                }
                ),
        elevation = 2.dp,
//        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DishImage(dish = dish)
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .width(100.dp),
            ) {
                Text(text = dish.name, fontWeight = FontWeight.Bold)
                Text(
                    text = "View Detail",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(20.dp),
            ) {
                Text(text = dish.price, fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Composable
fun DishImage(dish: Dish) {
    Image(
        painter = painterResource(id = dish.url_image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}