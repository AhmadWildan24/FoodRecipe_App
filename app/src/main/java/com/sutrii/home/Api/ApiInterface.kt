package com.sutrii.home.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET ("recipes")
    fun getData(): Call<List<FoodInfo>>
}