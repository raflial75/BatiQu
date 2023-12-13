package com.latihan.capstoneproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert
    fun addAllFavorite(favoritUser: FavoriteEntity)

    @Query("SELECT * FROM favorite_user")
    fun getAllFavorite(): LiveData<List<FavoriteEntity>>

    @Query("SELECT count(*) FROM favorite_user WHERE name = :name AND address = :address AND photo = :photo AND description = :description")
    fun favCheck(name: String, address: String, photo: String, description: String): Int

    @Query("DELETE FROM favorite_user WHERE name = :name AND address = :address AND photo = :photo AND description = :description")
    fun removeFavorite(name: String, address: String, photo: String, description: String): Int

}
