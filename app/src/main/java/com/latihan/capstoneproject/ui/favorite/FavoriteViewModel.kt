package com.latihan.capstoneproject.ui.favorite

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latihan.capstoneproject.database.FavoriteDao
import com.latihan.capstoneproject.database.FavoriteEntity
import com.latihan.capstoneproject.database.FavoriteRoomDatabase
import com.latihan.capstoneproject.response.Batik

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    private var favDao: FavoriteDao?
    private var favDatabase: FavoriteRoomDatabase?
    private val _batikList = MutableLiveData<List<Batik>>()
    val batikList: LiveData<List<Batik>> = _batikList
    init {
        favDatabase = FavoriteRoomDatabase.getDatabase(application)
        favDao = favDatabase?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteEntity>>? {
        return favDao?.getAllFavorite()
    }
=======
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is favorite Fragment"
    }
    val text: LiveData<String> = _text
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
}