package com.ynovlyon.ymenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.gson.Gson
import com.ynovlyon.ymenu.data.model.DishModel
import com.ynovlyon.ymenu.presentation.theme.YmenuOrange
import com.ynovlyon.ymenu.presentation.theme.YmenuOrangeAlt

@Composable
fun DishListItem(dish: DishModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    onClick()
                }
            ),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DishImage(dish = dish)
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .width(300.dp),
            ) {
                Text(text = dish.name, fontWeight = FontWeight.Bold, color = YmenuOrange, fontSize = 15.sp)
                Text(
                    text = dish.ingredients.joinToString(separator = ", "),
                    fontWeight = FontWeight.W300,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    color = Color.Gray
                )
                Card(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(9.dp),
                    backgroundColor = YmenuOrange,
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(text ="${dish.price}0 €", fontSize = 12.sp,fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(vertical = 5.dp, horizontal = 7.dp))
                }
            }
        }
    }
}


@Composable
fun DishImage(dish: DishModel) {
        Image(
            painter = rememberAsyncImagePainter(dish.url_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(13.dp),
                    clip = true
                )
                .size(height = 130.dp, width = 120.dp)
                .clip(RoundedCornerShape(corner = CornerSize(13.dp)))

        )
}