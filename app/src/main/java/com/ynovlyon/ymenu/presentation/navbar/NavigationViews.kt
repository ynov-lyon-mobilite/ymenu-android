package com.ynovlyon.ymenu

import android.content.Intent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.mlkit.vision.barcode.Barcode
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.ynovlyon.ymenu.camera.Camera
import com.ynovlyon.ymenu.camera.CameraPreview

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
