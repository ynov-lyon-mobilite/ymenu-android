package com.ynovlyon.ymenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ynovlyon.ymenu.ui.theme.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.ynovlyon.ymenu.data.model.DishModel

@Composable
fun DetailsPlats(
    navController: NavController,
    dish: DishModel
) {


    Scaffold(
        topBar = {
            Row {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
            }
        }
    ) {
        Column() {
            Text(
                text = "Détails du plat", style =
                TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(bottom = 12.dp, start = 12.dp)

            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,

            ) {

            val painter = rememberAsyncImagePainter(dish.url_logo)
            val description = "Bo bun boeuf avec nems"
            val title = dish.name
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title
            )
            Text(
                text = "Ingrédients", style =
                TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(10.dp)
            )

            for (ingredient in dish.ingredients) {
                LazyColumn(modifier = Modifier) {
                    items(items = dish.ingredients) {
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .height(0.2.dp)
                        )

                    }
                }
                Text(
                    text = ingredient,
                    style = TextStyle(fontSize = 15.sp),
                    modifier = Modifier
                        .padding(7.dp)
                )
            }

            Column(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)


            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Orange200),
                    onClick = {},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    //icon cube 3D pas trouver
                    //                    Icon(
                    //                        imageVector = Icons.Filled.Search,
                    //                        contentDescription = "Voir en RA",
                    //                        Modifier.padding(end = 8.dp)
                    //                    )
                    if (dish.url_model_android != "") {
                        Text(text = "Voir en RA", fontSize = 18.sp, color = Color.White)
                    }
                }

            }


        }
    }



}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(4.dp),
        shape = RoundedCornerShape(25.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(250.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(390.dp)
            )
            Box(modifier = Modifier
                .fillMaxSize()
                //effet
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )

            )
            //texte sur le card
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(19.dp),
                contentAlignment = Alignment.BottomStart)
            {
                Text(title,
                    style = TextStyle(color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ))
            }
        }
    }
}