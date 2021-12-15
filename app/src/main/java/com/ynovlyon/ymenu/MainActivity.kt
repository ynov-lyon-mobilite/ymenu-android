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
import com.ynovlyon.ymenu.presentation.theme.YMenuTheme
import com.ynovlyon.ymenu.presentation.theme.fonts

import androidx.compose.runtime.*
import com.ynovlyon.ymenu.presentation.onboarding.OnBoardScreen
import com.ynovlyon.ymenu.presentation.onboarding.OnBoardViewModel
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
}