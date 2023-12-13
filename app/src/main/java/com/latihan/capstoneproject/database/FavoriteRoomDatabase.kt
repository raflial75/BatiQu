package com.latihan.capstoneproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteEntity::class],
    version = 1
)
abstract class FavoriteRoomDatabase: RoomDatabase() {
    companion object{
        var INSTANCE : FavoriteRoomDatabase? = null

        fun getDatabase(context: Context): FavoriteRoomDatabase?{
            if (INSTANCE ==null){
                synchronized(FavoriteRoomDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, FavoriteRoomDatabase::class.java, "user_database").build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun favoriteUserDao(): FavoriteDao
}