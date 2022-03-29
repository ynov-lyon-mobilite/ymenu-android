package com.ynovlyon.ymenu.camera


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.graphics.RectF
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.ynovlyon.ymenu.ApiClient
import kotlinx.coroutines.*

class QrCodeAnalyzer(
    private val context: Context,
    private val qrCodeBoxView: QrCodeBoxView,
    private val navController: NavController
) : ImageAnalysis.Analyzer {

    /**
     * This parameters will handle preview box scaling
     */
    private var scaleX = 5f
    private var scaleY = 5f

    private fun translateX(x: Float) = x * scaleX
    private fun translateY(y: Float) = y * scaleY

    private fun adjustBoundingRect(rect: Rect) = RectF(
        translateX(rect.left.toFloat()),
        translateY(rect.top.toFloat()),
        translateX(rect.right.toFloat()),
        translateY(rect.bottom.toFloat())
    )

    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(image: ImageProxy) {
        val img = image.image
        if (img != null) {
            // Update scale factors
            scaleX = 500 / img.height.toFloat()
            scaleY = 500 / img.width.toFloat()

            val inputImage = InputImage.fromMediaImage(img, image.imageInfo.rotationDegrees)

            // Process image searching for barcodes
            val options = BarcodeScannerOptions.Builder()
                .build()

            val scanner = BarcodeScanning.getClient(options)

            scanner.process(inputImage)
                .addOnSuccessListener { barcodes ->
                    if (barcodes.isNotEmpty()) {
                        for (barcode in barcodes) {
                            // Handle received barcodes...
                            val qrCodeResult = barcode.rawValue
                            if (qrCodeResult !== null) {
                                val restaurantData: List<String> =
                                    qrCodeResult.split(',').map { it -> it.trim() }
                                val restaurantId: String = restaurantData[0]
                                val restaurantName: String = restaurantData[1]
                                executeCall(restaurantId)
                                switchToListing(navController)
                            }
                            // Update bounding rect
                            barcode.boundingBox?.let { rect ->
                                qrCodeBoxView.setRect(
                                    adjustBoundingRect(
                                        rect
                                    )
                                )
                            }
                        }
                    } else {
                        // Remove bounding rect
                        qrCodeBoxView.setRect(RectF())
                    }
                }
                .addOnFailureListener { }
        }

        image.close()
    }

    private fun executeCall(id: String){
        runBlocking {
            launch(Dispatchers.Default) {
                try {
                    val response = ApiClient.restaurantApiService.getRestaurantById(id)
                    if (response.isSuccessful && response.body() != null) {
                        val content = response.body()
                    }
                } catch (e: Exception) {
                    println(e)
                }
            }
        }
    }

    private fun switchToListing(navController: NavController) {
        navController.navigate("menu")
    }
}