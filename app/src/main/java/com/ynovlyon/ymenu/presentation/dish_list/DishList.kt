package com.ynovlyon.ymenu.presentation.dish_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.ynovlyon.ymenu.*
import com.ynovlyon.ymenu.data.DataProvider
import com.ynovlyon.ymenu.data.model.DishModel
import com.ynovlyon.ymenu.data.model.RestaurantModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun DishList(navController: NavController, id: String?) {
//    val dishes = remember { DataProvider.dishesList }
    var dishes : List<DishModel> = listOf()
    if (id != null && id != "{id}") {
        dishes = executeCall(id)
    }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        items(
            items = dishes,
            itemContent = {
                DishListItem(dish = it, navController = navController)
            },
        )
    }
}

enum class TabPage


fun executeCall(id: String): List<DishModel> {
    val apiInterface = ApiInterface.create().getDishesListById(id)
    var dishesList : List<DishModel> = listOf()
    apiInterface.enqueue(object : Callback<List<DishModel>> {
        override fun onResponse(
            call: Call<List<DishModel>>,
            response: Response<List<DishModel>>
        ) {
            if (response.body() == null) {
                return
            } else {
                dishesList = response.body()!!
            }
        }

        override fun onFailure(call: Call<List<DishModel>>, t: Throwable) {
            println(t)
        }
    })

    println(dishesList)
    return dishesList
}