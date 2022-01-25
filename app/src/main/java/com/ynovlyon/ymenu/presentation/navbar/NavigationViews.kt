package com.ynovlyon.ymenu

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ynovlyon.ymenu.data.Dish
import com.ynovlyon.ymenu.presentation.onboarding.Greeting
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.presentation.dish_list.DishList

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun Menu() {
    DishList()
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
}

