package com.example.foodapp.foodBookmark

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookmarkRepository @Inject constructor(private var bookmarkDao: BookmarkDao) {
    suspend fun addtoFavorite(bookmark: Bookmark){
        return bookmarkDao.addtoFavorite(bookmark)
    }
    fun getFavorite():LiveData<List<Bookmark>>{
        return bookmarkDao.getFavorite()
    }
    suspend fun getFavoriteId(id:String):Bookmark?{
        return bookmarkDao.getFavoriteId(id)
    }
    suspend fun deleteFavorite(id:String):Int{
        return bookmarkDao.deleteFavorite(id)
    }
}