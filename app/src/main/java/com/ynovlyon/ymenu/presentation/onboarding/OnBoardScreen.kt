package com.ynovlyon.ymenu.presentation.onboarding

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ynovlyon.ymenu.onBoardItem
import com.ynovlyon.ymenu.presentation.theme.fonts
import com.ynovlyon.ymenu.ui.theme.Orange200
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalPagerApi
@Composable
fun OnBoardScreen(onCompleted: () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val onBoardViewModel: OnBoardViewModel = viewModel()
    val context = LocalContext.current
    val currentPage = onBoardViewModel.currentPage.collectAsState()
    val currentPageValue = currentPage.value

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
                    page = currentPageValue
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
                                OutlinedButton(
                                    onClick = {
                                        onBoardViewModel.setCurrentPage(pagerState.currentPage + 1)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Orange200,
                                        contentColor = Color.White
                                    ),
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
                                        contentColor = Color.White
                                    ),
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
                        horizontalArrangement = if (pagerState.currentPage != 2) {
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
