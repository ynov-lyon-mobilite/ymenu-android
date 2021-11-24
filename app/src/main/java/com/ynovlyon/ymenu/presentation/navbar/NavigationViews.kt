package com.ynovlyon.ymenu

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

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
