package com.ynovlyon.ymenu.camera


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.graphics.RectF
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.navigation.NavController
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.ynovlyon.ymenu.ApiInterface
import com.ynovlyon.ymenu.data.model.RestaurantModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

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
                                val restaurantId: String? = restaurantData[0]
                                val restaurantName: String? = restaurantData[1]
                                if (restaurantId != null && restaurantName != null) {
                                    executeCall(restaurantId)
                                }
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

    private fun executeCall(id: String) {
        val apiInterface = ApiInterface.create().getRestaurantById(id)
        apiInterface.enqueue(object : Callback<RestaurantModel> {
            override fun onResponse(
                call: Call<RestaurantModel>,
                response: Response<RestaurantModel>
            ) {
                if (response.body() != null) {
                    switchToListing(response.body()!!._id.toString())
                }
            }

            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
            }
        })
    }

    private fun switchToListing(idRestaurant: String) {
        navController.navigate("menu/$idRestaurant") {
            popUpTo("qrCode") { inclusive = true }
        }
    }
}