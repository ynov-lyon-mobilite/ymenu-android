package com.ynovlyon.ymenu

import com.ynovlyon.ymenu.restaurant.RestaurantModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    companion object{
         var BASE_URL = "https://ymenu.herokuapp.com/api/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

    @GET("restaurants/{id}")
    fun getRestaurantById(@Path("id") id : String): Call<RestaurantModel>
}

