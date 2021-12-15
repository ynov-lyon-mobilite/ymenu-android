package com.ynovlyon.ymenu

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import androidx.compose.runtime.*
import com.ynovlyon.ymenu.presentation.onboarding.OnBoardScreen
import com.ynovlyon.ymenu.presentation.onboarding.OnBoardViewModel
import dev.burnoo.compose.rememberpreference.rememberBooleanPreference


@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private lateinit var cameraExecutor: ExecutorService

    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //DetailsPlats()
            YMenuTheme {
                // A surface container using the 'background' color from the theme
                //MyApp()
                YMenuTheme {
                    BottomNavigationView()
                }
            }
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun DetailsPlats(names: List<String> = listOf("Emince de boeuf", "Nouilles de riz", "Nem", "salade", "carotte")) {

        Column() {
            Text(
                text = "Détails du plat", style =
                TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,

            ) {


            val painter = painterResource(id = R.drawable.boeuf)
            val description = "Bo bun boeuf avec nems"
            val title = "Bo bun boeuf avec nems          13.90$"
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title
            )
            Text(
                text = "Ingrédients", style =
                TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            )


            for (name in names) {
                LazyColumn(modifier = Modifier) {
                    items(items = names) {
                        Divider()
                    }
                }
                Text(
                    text = name,
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier.padding(3.dp),

                    )
            }

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)


            ) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    //icon cube 3D pas trouver
//                    Icon(
//                        imageVector = Icons.Filled.Search,
//                        contentDescription = "Voir en RA",
//                        Modifier.padding(end = 8.dp)
//                    )
                    Text(text = "Voir en RA", fontSize = 18.sp)
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
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp),
            shape = RoundedCornerShape(25.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.height(290.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(390.dp)
                )
                Box(
                    modifier = Modifier
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(19.dp),
                    contentAlignment = Alignment.BottomStart
                )
                {
                    Text(
                        title,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}
