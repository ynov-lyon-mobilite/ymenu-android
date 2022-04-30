package com.ynovlyon.ymenu.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DishModel(
    val _id: String?,
    val name: String,
    val price: String,
    val url_logo: String,
    val restaurant_id: String?,
    val category_id: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val url_model_android: String? = null,
    val ingredients: List<String>
) : Parcelable