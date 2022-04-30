package com.ynovlyon.ymenu.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantModel(
    val _id: String? = null,
    val address: String? = null,
    val zipCode: String? = null,
    val city: String? = null,
    val phone: Int? = null,
    val name: String? = null,
    val url_logo: String? = null,
    val mail: String? = null,
    val user_id: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
) : Parcelable
