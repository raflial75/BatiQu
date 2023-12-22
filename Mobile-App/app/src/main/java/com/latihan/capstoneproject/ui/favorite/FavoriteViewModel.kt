package com.latihan.capstoneproject.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latihan.capstoneproject.database.FavouriteDao
import com.latihan.capstoneproject.database.FavouriteDatabase
import com.latihan.capstoneproject.database.FavouriteEntity
import com.latihan.capstoneproject.response.ItemsItem

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    private var userDao: FavouriteDao?
    private var userDatabase: FavouriteDatabase?
    private val _userList = MutableLiveData<List<ItemsItem>>()
    val userList: LiveData<List<ItemsItem>> = _userList
    init {
        userDatabase = FavouriteDatabase.getDatabase(application)
        userDao = userDatabase?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavouriteEntity>>? {
        return userDao?.getAllFavorite()
    }
}