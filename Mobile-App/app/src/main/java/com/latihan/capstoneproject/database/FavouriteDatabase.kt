package com.latihan.capstoneproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavouriteEntity::class],
    version = 2 // Updated version number
)
abstract class FavouriteDatabase : RoomDatabase() {
    companion object {
        private var INSTANCE: FavouriteDatabase? = null

        fun getDatabase(context: Context): FavouriteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteDatabase::class.java,
                    "user_database"
                )
                    .fallbackToDestructiveMigration() // Use this only during development, it clears and rebuilds the database on migration
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun favoriteUserDao(): FavouriteDao
}
