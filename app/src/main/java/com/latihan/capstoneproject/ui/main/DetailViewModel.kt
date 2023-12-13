package com.latihan.capstoneproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latihan.capstoneproject.database.FavoriteDao
import com.latihan.capstoneproject.database.FavoriteEntity
import com.latihan.capstoneproject.database.FavoriteRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private var favDao: FavoriteDao?
    private var favDb: FavoriteRoomDatabase?

    init {
        favDb = FavoriteRoomDatabase.getDatabase(application)
        favDao = favDb?.favoriteUserDao()
    }
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun addToFavorite(name: String, address: String, photo: String, description: String){
        CoroutineScope(Dispatchers.IO).launch{
            val batik = FavoriteEntity(
                name,
                address,
                photo,
                description
            )
            favDao?.addAllFavorite(batik)
        }
    }

    fun favCheck(name: String, address: String, photo: String, description: String)= favDao?.favCheck(name, address, photo, description)

    fun removeFromFavorite(name: String, address: String, photo: String, description: String){
        CoroutineScope(Dispatchers.IO).launch {
            favDao?.removeFavorite(name, address, photo, description)
        }
    }
    companion object {
        private const val TAG = "DetailViewModel"
    }

}