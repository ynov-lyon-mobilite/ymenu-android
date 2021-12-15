package com.ynovlyon.ymenu

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.ynovlyon.ymenu.presentation.theme.fonts

import androidx.compose.runtime.*
import dev.burnoo.compose.rememberpreference.rememberBooleanPreference


@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private lateinit var cameraExecutor: ExecutorService

    @ExperimentalPermissionsApi
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
    fun OnBoardScreen(onCompleted: () -> Unit) {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val onBoardViewModel: OnBoardViewModel = viewModel()
        val context = LocalContext.current
        val currentPage = onBoardViewModel.currentPage.collectAsState()

        Toast.makeText(context, "${currentPage.value}", Toast.LENGTH_SHORT).show()

        val pagerState = rememberPagerState(
            pageCount = onBoardItem.size,
            initialOffscreenLimit = 2,
            initialPage = 0,
            infiniteLoop = false
        )

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
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
