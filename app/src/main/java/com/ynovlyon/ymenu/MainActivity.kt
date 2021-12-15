package com.ynovlyon.ymenu

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme
import com.ynovlyon.ymenu.presentation.theme.fonts

import androidx.compose.runtime.*
import androidx.loader.content.Loader
import dev.burnoo.compose.rememberpreference.rememberBooleanPreference


@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        // SharedPreferences preferences = getSharedPreferences('PREFERENCE', MODE_PRIVATE);


        setContent {
            //DetailsPlats()
            YMenuTheme {

                setContent {

                    var isOnboardingCompleted by rememberBooleanPreference(
                        keyName = "onboardingKey", // preference is stored using this key
                        initialValue = null, // returned before preference is loaded
                        defaultValue = false, // returned when preference is not set yet
                    )
                    when (isOnboardingCompleted) {
                        null -> null
                        false -> OnBoardScreen(onCompleted = { isOnboardingCompleted = true })
                        true -> BottomNavigationView()
                    }
                    //OnBoardScreen { isOnboardingCompleted = true }

                    // Get the shared preferences
                    // val preferences = getSharedPreferences("my_preferences", MODE_PRIVATE)

                    //if (!preferences.getBoolean("onboarding_complete", false)) {
                      //  OnBoardScreen { isOnboardingCompleted = true }

                    //}
                }
            }
        }
    }

@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalPagerApi
@Composable
fun OnBoardScreen(onCompleted: () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val onBoardViewModel : OnBoardViewModel = viewModel()
    val context = LocalContext.current
    val currentPage = onBoardViewModel.currentPage.collectAsState()

    Toast.makeText(context, "${currentPage.value}", Toast.LENGTH_SHORT).show()

    val pagerState = rememberPagerState(
        pageCount = onBoardItem.size,
        initialOffscreenLimit = 2,
        initialPage = 0,
        infiniteLoop = false
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            scope.launch {
                pagerState.animateScrollToPage(
                    page = currentPage.value
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HorizontalPager(
                        state = pagerState
                    ) { page ->
                        Column(
                            modifier = Modifier
                                .padding(top = 65.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = onBoardItem[page].image),
                                contentDescription = "OnBoardImage",
                                modifier = Modifier
                                    .size(250.dp)
                            )

                            Text(
                                text = onBoardItem[page].title,
                                modifier = Modifier
                                    .padding(top = 50.dp),
                                textAlign = TextAlign.Center,
                                color = Orange200,
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp
                            )

                            Text(
                                text = onBoardItem[page].desc,
                                modifier = Modifier
                                    .padding(30.dp),
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )

                            if (pagerState.currentPage != 2) {
                                OutlinedButton (
                                    onClick = {
                                        onBoardViewModel.setCurrentPage(pagerState.currentPage + 1)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Orange200,
                                        contentColor = Color.White),
                                    shape = RoundedCornerShape(45.dp)
                                ) {
                                    Text(
                                        text = "Suivant",
                                        fontFamily = fonts,
                                        color = Color.White,
                                        modifier = Modifier
                                            .padding(
                                                vertical = 8.dp,
                                                horizontal = 40.dp
                                            )
                                    )
                                }
                            } else {
                                OutlinedButton(
                                    onClick = onCompleted,
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Orange200,
                                        contentColor = Color.White),
                                    shape = RoundedCornerShape(45.dp)
                                ) {
                                    Text(
                                        text = "C'est parti !",
                                        fontFamily = fonts,
                                        modifier = Modifier
                                            .padding(
                                                vertical = 8.dp,
                                                horizontal = 40.dp
                                            ),
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }

                    PagerIndicator(onBoardItem.size, pagerState.currentPage)
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = if (pagerState.currentPage != 2 ) {
                            Arrangement.SpaceBetween
                        } else {
                            Arrangement.Center
                        }
                    ) {}
                    }
                }
            }
        }
    }

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            IndicateIcon(
                isSelected = it == currentPage
            )
        }
    }
}

@Composable
fun IndicateIcon(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp
    )

    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) {
                    Orange200
                } else {
                    Color.Gray.copy(alpha = 0.5f)
                }
            )
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
