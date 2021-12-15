package com.ynovlyon.ymenu

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ynovlyon.ymenu.presentation.onboarding.Greeting
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun Menu() {
    Greeting("menu")
}
@ExperimentalPermissionsApi
@Composable
fun QrCode(){
    Camera()
}

@Composable
fun iui(){
}

@Composable
fun Account(){
    Greeting("account")
}
