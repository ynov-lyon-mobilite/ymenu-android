package com.ynovlyon.ymenu.camera

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.text.style.AlignmentSpan
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ViewInAr
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ynovlyon.ymenu.util.CameraPermission
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.ynovlyon.ymenu.presentation.theme.YmenuOrange
import com.ynovlyon.ymenu.ui.theme.Orange200

@ExperimentalPermissionsApi
@Composable
fun Camera(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    CameraPermission(
        permission = android.Manifest.permission.CAMERA,
        rationale = "Pour pouvoir scanner un QR code il est nécessaire d'autoriser l'application à utiliser la caméra.",
        permissionNotAvailableContent = {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.align(alignment = Alignment.Center).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = CenterHorizontally) {
                    Text(
                        "Pas de caméra, pas de chocolat!", style =
                        TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Merci d'autoriser l'application à utiliser la caméra de votre appareil afin de pouvoir scanner un code QR", style =
                        TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = Orange200),
                        onClick = {
                            context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                data = Uri.fromParts("package", context.packageName, null)
                            })
                        },
                        shape = RoundedCornerShape(9.dp),
                        contentPadding = PaddingValues(horizontal = 80.dp, vertical = 13.dp)
                    ) {

                        Text(text = "Ouvrir les paramètres", fontSize = 15.sp, color = Color.White)
                    }
                }
            }
        }
    ) {
        CameraPreview(navController)
    }
}