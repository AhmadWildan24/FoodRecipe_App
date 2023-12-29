package com.example.foodapp.foodBookmark

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookmarkDao {
    @Insert
    fun addtoBookmark(bookmark: Bookmark)

    @Query("SELECT * FROM favMeals")
    fun getBookmark():LiveData<List<Bookmark>>

    @Query("SELECT * FROM favMeals where idMeal=:idMeal")
    fun getBookmarkId(idMeal:String):Bookmark?

    @Query("DELETE FROM favMeals where idMeal=:idMeal")
    fun deleteBookmark(idMeal: String):Int
}