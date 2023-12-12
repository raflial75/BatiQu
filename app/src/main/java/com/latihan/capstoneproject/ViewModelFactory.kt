package com.latihan.capstoneproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.latihan.capstoneproject.data.pref.UserPreference
import com.latihan.capstoneproject.ui.login.LoginViewModel
import com.latihan.capstoneproject.ui.maps.MapsViewModel
import com.latihan.capstoneproject.ui.upload.UploadViewModel

class ViewModelFactory(private val pref: UserPreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }

            modelClass.isAssignableFrom(MapsViewModel::class.java) -> {
                MapsViewModel(pref) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}