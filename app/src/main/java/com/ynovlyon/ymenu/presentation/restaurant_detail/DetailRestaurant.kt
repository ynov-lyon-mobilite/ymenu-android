package com.ynovlyon.ymenu.presentation.restaurant_detail

import android.widget.ImageSwitcher
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
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

    ){
//        Column (
//            modifier = Modifier.height(50.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ){
//            Text(
//                text = "Auto sliding ",
//                color = Color.White,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }

       // Spacer(modifier = Modifier.height(30.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 18.dp, 0.dp, 50.dp)

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
                    .padding(10.dp, 170.dp, 15.dp, 160.dp),
                shape = RoundedCornerShape(20.dp)

            ){
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .align(Alignment.Center), contentAlignment = Alignment.CenterStart
                ){
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

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(15.dp)

                    ) {

                    }
                }


            }

        }

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {


        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        {
            Text("Minute Asiat")
            Text("€€ . Restaurant asiatique")
            Text( "11:00 - 23:00")
            Text("A propos")
            Text("A travers cette application vous pourrez découvrir " +
                    "les différents menus ainsi que leurs plats en réalité augmentée." +
                    "Visualisez votre plat sur votre table avant" +
                    "même de l'avoir commandé.")



        }




    }

}


