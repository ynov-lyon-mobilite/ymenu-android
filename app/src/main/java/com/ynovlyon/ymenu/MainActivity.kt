package com.ynovlyon.ymenu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ynovlyon.ymenu.ui.theme.*
import kotlinx.coroutines.launch
@ExperimentalPagerApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        setContent {
            YMenuTheme {
                BottomNavigationView()
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun OnBoardScreen() {
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
                                color = ColorTitle,
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
                                    onClick = {},
                                    border = BorderStroke(2.dp, Color.Black),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Orange200,
                                        contentColor = Color.White),
                                    shape = RoundedCornerShape(45.dp)
                                ) {
                                    Text(
                                        text = "Suivant",
                                        fontFamily = fonts,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .padding(
                                                vertical = 8.dp,
                                                horizontal = 40.dp
                                            )
                                            .clickable {
                                                onBoardViewModel.setCurrentPage(pagerState.currentPage + 1)
                                            }
                                    )
                                }
                            } else {
                                OutlinedButton(
                                    onClick = {
                                    },
                                    border = BorderStroke(2.dp, Color.Black),
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
                                        color = Color.Black
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
                    Color.Black
                } else {
                    Color.Gray.copy(alpha = 0.5f)
                }
            )
    )
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}