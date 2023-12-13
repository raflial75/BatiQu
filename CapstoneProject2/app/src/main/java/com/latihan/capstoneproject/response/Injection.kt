package com.latihan.capstoneproject.response

import com.latihan.capstoneproject.api.ApiConfig
import com.latihan.capstoneproject.api.ApiService

object Injection {
    fun provideRepository(): ApiService {
        val apiService = ApiConfig.getApiService()
        return apiService
    }
}
