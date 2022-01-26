package com.ynovlyon.ymenu

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ynovlyon.ymenu.restaurant.RestaurantApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://ymenu.herokuapp.com/api/"

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val restaurantApiService: RestaurantApiService by lazy {
        retrofit.create(RestaurantApiService::class.java)
    }
}