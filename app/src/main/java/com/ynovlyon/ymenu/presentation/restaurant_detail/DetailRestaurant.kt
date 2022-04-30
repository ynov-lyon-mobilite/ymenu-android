package com.ynovlyon.ymenu.presentation.restaurant_detail

import android.widget.ImageSwitcher
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.rounded.RestaurantMenu
import androidx.compose.material.icons.rounded.ViewInAr
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.ynovlyon.ymenu.R
import com.ynovlyon.ymenu.data.model.RestaurantModel
import com.ynovlyon.ymenu.ui.theme.Orange200
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun DetailRestaurant(restaurant: RestaurantModel, navController: NavController){
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
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()


        ){

            HorizontalPager(
                verticalAlignment = Alignment.CenterVertically,
                state = pagerState,
                modifier = Modifier
                    .weight(1f)
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
                            .fillMaxHeight(0.80f)

                    )
                    {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(
                                    data = when(page){
                                        1 -> restaurant.url_logo
                                        2 ->  restaurant.url_logo
                                        else ->  restaurant.url_logo
                                    })
                                .crossfade(true)
                                .build(),
                            contentDescription = "Image de ${restaurant.name}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
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
                    "${restaurant.name}",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold)
                Text("${restaurant.speciality}",
                    fontSize = 17.sp,)
                Spacer(modifier = Modifier.padding(5.dp))
                Text( "11:00 - 23:00")

                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    "À propos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("${restaurant.description}",
                    fontSize = 16.sp,)
            }

            Spacer(modifier = Modifier.padding(20.dp))
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange200),
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(9.dp),
                contentPadding = PaddingValues(horizontal = 80.dp, vertical = 13.dp),
                modifier = Modifier
                        .padding(bottom = 100.dp)
            ) {

                Text(text = "Découvrir la carte", fontSize = 18.sp, color = Color.White)
                Icon(
                    imageVector = Icons.Rounded.RestaurantMenu,
                    contentDescription = "Découvrir la carte",
                    tint = Color.White,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }
    }

}


