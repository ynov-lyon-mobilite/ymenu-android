package com.ynovlyon.ymenu.data


data class Dish (
    val id: Int,
    val restaurant_id: Int,
    val name: String,
    val price: String,
    val url_image: Int = 0,
    val url_model: String,
    val category_id: Int,
    val ingredients: List<Ingredients>,
)