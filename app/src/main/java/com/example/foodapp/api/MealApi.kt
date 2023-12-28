package com.example.foodapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    companion object{
        const val BASE_URL="https://www.themealdb.com/api/json/v1/1/"
    }

    @GET("random.php")
    suspend fun randomMeal():MealResponse

    @GET("search.php?")
    suspend fun searchMeal(
        @Query("s")s:String
    ):MealResponse

    @GET("lookup.php?")
    fun detailMeal(
        @Query("i")i:String
    ):Call<MealResponse>
}