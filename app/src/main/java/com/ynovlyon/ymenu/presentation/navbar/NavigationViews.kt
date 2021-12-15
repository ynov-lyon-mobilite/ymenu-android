package com.ynovlyon.ymenu

import androidx.compose.runtime.Composable
import com.ynovlyon.ymenu.presentation.onboarding.Greeting

@Composable
fun Menu() {
    Greeting("menu")
}

@Composable
fun QrCode(){
    Greeting("qrcode")
}

@Composable
fun Account(){
    Greeting("account")
}
