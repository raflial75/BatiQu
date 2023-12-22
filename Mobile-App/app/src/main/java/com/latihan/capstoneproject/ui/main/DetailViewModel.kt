package com.latihan.capstoneproject.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latihan.capstoneproject.api.ApiConfig
import com.latihan.capstoneproject.database.FavouriteDao
import com.latihan.capstoneproject.database.FavouriteDatabase
import com.latihan.capstoneproject.database.FavouriteEntity
import com.latihan.capstoneproject.response.ResponseSearchDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private var userDao: FavouriteDao?
    private var userDb: FavouriteDatabase?

    init {
        userDb = FavouriteDatabase.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }
    private val _userDetail = MutableLiveData<ResponseSearchDetail>()
    val userDetail: LiveData<ResponseSearchDetail> = _userDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getName(name: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getnameDetail(name)
        client.enqueue(object : Callback<ResponseSearchDetail> {
            override fun onResponse(
                call: Call<ResponseSearchDetail>,
                response: Response<ResponseSearchDetail>
            ) {

                if (response.isSuccessful) {
                    _isLoading.value = false
                    _userDetail.value = response.body()
                } else {
                    Log.e(TAG, "onFailure: gagal")
                }
            }

            override fun onFailure(call: Call<ResponseSearchDetail>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
    fun addToFavorite(name: String, address: String, photo: Int, description: String){
        CoroutineScope(Dispatchers.IO).launch{
            val user = FavouriteEntity(
                name,
                address,
                photo,
                description
            )
            userDao?.addAllFavorite(user)
        }
    }

    fun checkUser(name: String, address: String, photo: Int, description: String)= userDao?.userCheck(name, address, photo, description)

    fun removeFromFavorite(name: String, address: String, photo: Int, description: String){
        CoroutineScope(Dispatchers.IO).launch {
            userDao?.removeFavorite(name, address, photo, description)
        }
    }
    companion object {
        private const val TAG = "DetailViewModel"
    }


}