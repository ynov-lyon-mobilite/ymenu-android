package com.ynovlyon.ymenu

import android.graphics.Paint
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ynovlyon.ymenu.ui.theme.*
import kotlinx.coroutines.launch
import androidx.compose.runtime.Composable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.NavigationBar
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.ynovlyon.ymenu.presentation.theme.fonts
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.ynovlyon.ymenu.data.Ingredients

@Preview(showBackground = true)
@Composable
fun DetailsPlats(names: List<Ingredients> = listOf(Ingredients(id = 1,dish_id = 2, name = "test"),Ingredients(id = 2,dish_id = 2, name = "test2"),Ingredients(id = 3,dish_id = 2, name = "test3"),Ingredients(id = 4,dish_id = 2, name = "test4"),Ingredients(id = 5,dish_id = 2, name = "test5"),Ingredients(id = 6,dish_id = 2, name = "test6"),Ingredients(id = 7,dish_id = 2, name = "test7"),Ingredients(id = 8,dish_id = 2, name = "test8")), navController: NavController) {
    Scaffold(
        topBar = {
            Row {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.navigate("menu")
                        }
                )
                Text(
                    text = "Détails du plat", style =
                    TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,

            ) {

            val painter = painterResource(id = R.drawable.boeuf)
            val description = "Bo bun boeuf avec nems"
            val title = "Bo bun boeuf avec nems                13.90€"
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title
            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange200),
                onClick = {},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                //icon cube 3D pas trouver
                //                    Icon(
                //                        imageVector = Icons.Filled.Search,
                //                        contentDescription = "Voir en RA",
                //                        Modifier.padding(end = 8.dp)
                //                    )
                Text(text = "Voir en RA", fontSize = 18.sp, color = Color.White)
            }

            Text(
                text = "Ingrédients", style =
                TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(10.dp)
            )

            LazyColumn(
                modifier = Modifier,
                contentPadding = PaddingValues(bottom = 100.dp),) {
                items(
                    items = names,
                    itemContent = {
                        IngredientsListItem(ingredient = it, navController = navController)
                    }
                )
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
        Box(modifier = Modifier.height(200.dp)) {
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