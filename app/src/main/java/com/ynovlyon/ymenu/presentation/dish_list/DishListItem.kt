package com.ynovlyon.ymenu

import android.graphics.Color
import android.preference.PreferenceActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.Dish
import com.ynovlyon.ymenu.data.DishCategory
import com.ynovlyon.ymenu.presentation.theme.YmenuOrangeAlt
import kotlinx.coroutines.launch


@Composable
fun DishListItem(dish: Dish, navController: NavController) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    coroutineScope.launch{
                        listState.animateScrollToItem(index = 10)
                    }
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

@Composable
fun ListDishCategory( dishCategory : DishCategory, index: Int, selected: Boolean, onClick: (Int) -> Unit){
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 0.dp, end = 30.dp, bottom = 0.dp)
    ) {
        Text(
            text =  dishCategory.name,
            modifier = Modifier
                .clickable {
                    onClick.invoke(index)
                }
                .background(if (selected) YmenuOrangeAlt else MaterialTheme.colors.onPrimary )
                .fillMaxWidth()
                .padding(3.dp)
        )
    }
}

@Composable
fun NameCategoryHeader(dishCategory : DishCategory){
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 0.dp, end = 30.dp, bottom = 0.dp)
    ) {
        Text(
            text =  dishCategory.name,
        )
    }
}
