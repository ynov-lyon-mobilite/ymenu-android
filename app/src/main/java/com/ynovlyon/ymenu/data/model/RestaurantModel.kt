package com.ynovlyon.ymenu.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantModel(
    val _id: String?,
    val address: String?,
    val zipCode: String?,
    val city: String?,
    val phone: Int?,
    val name: String?,
    val url_logo: String?,
    val mail: String?,
    val speciality: String?,
    val user_id: String?,
    val description: String?,
    val createdAt: String?,
    val updatedAt: String?,
) : Parcelable
