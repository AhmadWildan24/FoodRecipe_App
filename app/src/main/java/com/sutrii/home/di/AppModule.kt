package com.sutrii.home.di

object AppModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {
        @Singleton
        @Provides
        fun providesRetrofit():Retrofit=Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @Singleton
        @Provides
        fun providesApi(retrofit: Retrofit):MealApi=retrofit.create(MealApi::class.java)
    }
}