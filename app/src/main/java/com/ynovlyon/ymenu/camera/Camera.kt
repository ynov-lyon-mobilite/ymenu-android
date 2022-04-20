package com.ynovlyon.ymenu.camera

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.util.CameraPermission
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalPermissionsApi
@Composable
fun Camera(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    CameraPermission(
        permission = android.Manifest.permission.CAMERA,
        rationale = "Pour pouvoir scanner un QR code nous allons avoir besoin de l'autorisation d'utiliser votre caméra.",
        permissionNotAvailableContent = {
            Column(modifier) {
                Text("Pas de camera, pas de chocolat")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package", context.packageName, null)
                    })
                }) {
                    Text("Ouvrir les paramètres ")
                }
            }
        }
    ) {
        CameraPreview(navController)
    }
}