package com.latihan.capstoneproject.ui.main

import android.content.Context
import androidx.lifecycle.*
import com.latihan.capstoneproject.data.pref.UserModel
import com.latihan.capstoneproject.data.pref.UserPreference
import kotlinx.coroutines.launch

class MainViewModel(private val pref: UserPreference) : ViewModel() {

    class ViewModelFactory(private val context: Context, private val pref: UserPreference) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(pref) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }


    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }

    fun getUser(): LiveData<UserModel> {
        return pref.getUser().asLiveData()
    }
}