package com.sutrii.home.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    companion object{
        const val BASE_URL="https://www.themealdb.com/api/json/v1/1/"

    }
    @GET("search.php")
    fun searchMeal(
        @Query("s")s:String
    ): Call<MealResponse>
}