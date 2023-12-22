package com.latihan.capstoneproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteDao {
    @Insert
    fun addAllFavorite(favoritUser: FavouriteEntity)

    @Query("SELECT * FROM favorite_user")
    fun getAllFavorite(): LiveData<List<FavouriteEntity>>

    @Query("SELECT count(*) FROM favorite_user WHERE name = :name AND address = :address AND photo = :photo AND description = :description")
    fun userCheck(name: String, address: String, photo: Int, description: String): Int

    @Query("DELETE FROM favorite_user WHERE name = :name AND address = :address AND photo = :photo AND description = :description")
    fun removeFavorite(name: String, address: String, photo: Int, description: String): Int
}
