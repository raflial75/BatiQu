package com.latihan.capstoneproject.ui.maps

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.latihan.capstoneproject.api.ApiConfig
import com.latihan.capstoneproject.data.pref.UserModel
import com.latihan.capstoneproject.data.pref.UserPreference
import com.latihan.capstoneproject.response.MapsResponse
import com.latihan.capstoneproject.response.MapsStory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsViewModel(private val pref: UserPreference): ViewModel() {

    val data = MutableLiveData<ArrayList<MapsStory>>()

    fun getMapsStory(token: String) {
        val retro = ApiConfig.getApiService().getStoryMaps("Bearer $token")
        retro.enqueue(object : Callback<MapsResponse> {
            override fun onResponse(call: Call<MapsResponse>, response: Response<MapsResponse>) {
                if (response.isSuccessful) {
                    data.postValue(response.body()?.listStory as ArrayList<MapsStory>)
                    Log.d("Result MapsModel : ", (response.body()?.listStory as List<MapsStory>).toString())
                }
                else {
                    Log.d("Error : ", response.message().toString())
                }
            }
            override fun onFailure(call: Call<MapsResponse>, t: Throwable) {
                Log.d("onFailure", t.message!!)
            }
        })
    }
    fun getUser(): LiveData<UserModel> {
        return pref.getUser().asLiveData()
    }
    fun getMaps(): LiveData<ArrayList<MapsStory>> {
        return data
    }
}