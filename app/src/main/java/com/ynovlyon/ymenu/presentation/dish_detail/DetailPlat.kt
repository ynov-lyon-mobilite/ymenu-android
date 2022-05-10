package com.ynovlyon.ymenu

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ynovlyon.ymenu.ui.theme.*
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.ArrowBack
import com.ynovlyon.ymenu.data.model.DishModel
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ViewInAr
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat.startActivity

@Composable
fun DetailsPlats(
    navController: NavController,
    dish: DishModel
) {
    var showAr by remember { mutableStateOf(false) }

    if (showAr) {
        ShowAr(dish = dish)
    }

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
                Text(
                    modifier = Modifier.padding(top = 14.dp),
                    text = "Menu", style =
                    TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,

            ) {

            val painter = dish.url_logo
            val description = dish.name
            val title = dish.name
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title,
                price = dish.price
            )
            if (dish.url_model_android != null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = Orange200),
                        onClick = {
                            showAr = true
                        },
                        shape = RoundedCornerShape(9.dp),
                        contentPadding = PaddingValues(horizontal = 80.dp, vertical = 13.dp)
                    ) {

                        Text(text = "Voir en RA", fontSize = 16.sp, color = Color.White)
                        Icon(
                            imageVector = Icons.Rounded.ViewInAr,
                            contentDescription = "Voir en RA",
                            tint = Color.White,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }

            }

            Text(
                text = "Ingrédients", style =
                TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(vertical = 20.dp)
            )
            Card(
                modifier = Modifier
                    .padding(horizontal = 25.dp, vertical = 5.dp)
                    .padding(bottom = 80.dp),
                elevation = 2.dp,
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                content = {
                    Column(modifier = Modifier) {
                        for (name in dish.ingredients) {
                            Text(
                                text = name,
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier
                                    .padding(17.dp)
                                    .padding(start = 10.dp)
                            )
                            Divider(
                                modifier = Modifier
                                    .height(0.2.dp)
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun ShowAr(dish: DishModel) {
    val context = LocalContext.current

    val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
    val intentUri =
        Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
            .appendQueryParameter(
                "file",
                dish.url_model_android
            )
            .appendQueryParameter("mode", "ar_preferred")
            .appendQueryParameter("title", dish.name)
            .appendQueryParameter("resizeable", "false")
            .build()
    sceneViewerIntent.setData(intentUri)
    sceneViewerIntent.setPackage("com.google.ar.core")

    context.startActivity(sceneViewerIntent)
}

@Composable
fun ImageCard(
    painter: String,
    contentDescription: String,
    title: String,
    price: Float,
) {
        Box(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(painter)
                    .crossfade(true)
                    .build(),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(500.dp)
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
                        startY = 400f
                    )
                )

            )
            //texte sur le card
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(19.dp),
                contentAlignment = Alignment.BottomStart)
            {
                Row {
                    Text(title,
                        style = TextStyle(color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ))
                }
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(19.dp),
                contentAlignment = Alignment.BottomEnd)
            {
                Row {
                    Text("${price}0 €",
                        style = TextStyle(color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        ))
                }
            }
        }

}
