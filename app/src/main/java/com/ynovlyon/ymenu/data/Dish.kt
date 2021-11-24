package com.ynovlyon.ymenu.data

data class Dish (
    val id: Int,
    val name: String,
    val price: String,
    val dishesPictId: Int = 0,
    val category: String,
)