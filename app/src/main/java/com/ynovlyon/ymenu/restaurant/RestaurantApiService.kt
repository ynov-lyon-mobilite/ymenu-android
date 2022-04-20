package com.ynovlyon.ymenu.restaurant

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApiService {
    @GET("restaurants/{id}")
    suspend fun getRestaurantById(@Path("id") id : String): Response<RestaurantModel>
}