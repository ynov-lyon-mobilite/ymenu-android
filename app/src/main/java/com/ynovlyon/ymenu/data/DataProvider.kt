package com.ynovlyon.ymenu.data

import com.ynovlyon.ymenu.R

object DataProvider {

    val dishesList = listOf(
        Dish(
            id = 1,
            restaurant_id = 1,
            name = "Porc saté soja",
            price = "1550,5 €",
            url_image = R.drawable.p1,
            url_model = "",
            category_id = 1,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 1,
            restaurant_id = 1,
            name = "Porc saté ",
            price = "1550,5 €",
            url_image = R.drawable.p2,
            url_model = "",
            category_id = 1,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 1,
            restaurant_id = 1,
            name = "Poulet saté soja",
            price = "155 €",
            url_image = R.drawable.p3,
            "",
            2,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 1,
            restaurant_id = 1,
            name = "Boeuf saté soja",
            price = "155 €",
            url_image = R.drawable.p4,
            url_model = "",
            category_id = 2,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 2 ,
            restaurant_id = 1,
            name = "Crevette soja",
            price = "155 €",
            url_image = R.drawable.p5,
            url_model = "",
            category_id = 2,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 3,
            restaurant_id = 1,
            name = "Porc saté mais ",
            price = "12,5 €",
            url_image = R.drawable.p2,
            url_model = "",
            category_id = 3,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 4,
            restaurant_id = 1,
            name = "Poulet saté ",
            price = "12,5 €",
            url_image = R.drawable.p3,
            url_model = "",
            category_id = 3,
            ingredients = listOf(Ingredients(
                dish_id = 4,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 6,
            restaurant_id = 1,
            name = "Boeuf  soja",
            price = "12,5 €",
            url_image = R.drawable.p4,
            url_model = "",
            category_id = 3,
            ingredients = listOf(Ingredients(
                dish_id = 1,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 7,
            restaurant_id = 1,
            name = "Crevette ",
            price = "12,5 €",
            url_image = R.drawable.p5,
            url_model = "",
            category_id = 3,
            ingredients = listOf(Ingredients(
                dish_id = 2,
                id = 2,
                name = "maîs"
            ))
        ),
        Dish(
            id = 8,
            restaurant_id = 1,
            name = "Poulet saté ",
            price = "12,5 €",
            url_image = R.drawable.p3,
            url_model = "",
            category_id = 3,
            ingredients = listOf(Ingredients(
                dish_id = 4,
                id = 2,
                name = "maîs"
            ))
        ),
    )


    val categoryList = listOf(
        DishCategory(
            id = 1,
            restaurant_id =  1,
            name = "Entrée",
            category_id = 1,
            index = 1
        ),
        DishCategory(
            id = 2,
            restaurant_id = 1,
            name = "Plats",
            category_id = 2,
            index =  2
        ),
        DishCategory(
            id = 3,
            restaurant_id = 1,
            name = "Dessert",
            category_id = 3,
            index = 3
        ),
        DishCategory(
            id = 4,
            restaurant_id = 1,
            name = "David en y",
            category_id = 4,
            index = 4
        ),
        DishCategory(
            id = 5,
            restaurant_id = 1,
            name = "Davidn  en y",
            category_id = 4,
            index = 5
        )

    )
}