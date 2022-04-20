package com.ynovlyon.ymenu.data.model

data class DishModel(
    val _id: String? = null,
    val name: String,
    val price: String,
    val url_logo: String,
    val restaurant_id: String? = null,
    val category_id: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val url_model_ios: String? = null,
    val ingredients: List<String>
)