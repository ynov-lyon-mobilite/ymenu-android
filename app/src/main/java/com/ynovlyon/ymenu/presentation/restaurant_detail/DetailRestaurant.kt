package com.ynovlyon.ymenu.presentation.restaurant_detail

import android.widget.ImageSwitcher
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.ynovlyon.ymenu.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DetailRestaurant(){
    val pagerState = rememberPagerState(
        pageCount = 3,
        initialOffscreenLimit = 1
    )
    LaunchedEffect(Unit){
        while (true){
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )

        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(18.dp)
            .fillMaxWidth()


    ){

        HorizontalPager(
            verticalAlignment = Alignment.CenterVertically,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 18.dp, 0.dp, 0.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pagerOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
            ){
               Column(
                   horizontalAlignment = Alignment.Start,
                   verticalArrangement = Arrangement.Top,
                   modifier = Modifier
                       .fillMaxWidth()
                       .fillMaxHeight(0.68f)

               )
                {
                    Image(painter = painterResource(
                        id = when(page){

                            1 -> R.drawable.restaurant1
                            2 -> R.drawable.restaurant2
                            else -> R.drawable.restaurant3
                        })
                        , contentDescription = ""
                        ,contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()

                    )

                }


            }

        }

        Column(
            //horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ){
            Text(
                "Minute Asia",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )
            Text("€€ . Restaurant asiatique",
                fontSize = 17.sp,)
            Spacer(modifier = Modifier.padding(5.dp))
            Text( "11:00 - 23:00")

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                "A propos",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text("A travers cette application vous pourrez découvrir " +
                    "les différents menus ainsi que leurs plats en réalité augmentée." +
                    "Visualisez votre plat sur votre table avant " +
                    "même de l'avoir commandé.",
                fontSize = 16.sp,)




        }



        Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 100.dp)
                    .height(38.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFDAF5E),
                    contentColor = Color(0xFFFAF4FA)

                )
            ) {
                Text(text = "Découvrir la carte")
                Spacer(modifier = Modifier.padding(2.dp))

            }


    }



}


