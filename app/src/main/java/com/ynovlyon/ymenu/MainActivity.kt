package com.ynovlyon.ymenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ynovlyon.ymenu.ui.theme.YMenuTheme
import com.ynovlyon.ymenu.ui.theme.YmenuHome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YMenuTheme {
                MyApp()
            }
        }
    }
}
@Preview(name= "DIshes List")
@Composable
fun MyApp() {
    Scaffold(
        content = {
            YmenuHome()
        }
    )
}