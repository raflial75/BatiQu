package com.latihan.capstoneproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite_user")
data class FavoriteEntity(
    @PrimaryKey
    val name: String,
    val address: String,
    val photo: String,
    val description: String = ""
): Serializable
