package com.latihan.capstoneproject.ui.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.latihan.capstoneproject.data.pref.UserPreference

class UploadViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Upload Fragment"
    }
    val text: LiveData<String> = _text
}