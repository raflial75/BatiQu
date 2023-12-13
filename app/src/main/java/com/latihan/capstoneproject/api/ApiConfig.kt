package com.latihan.capstoneproject.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    fun getApiService(): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            .baseUrl("https://story-api.dicoding.dev/v1/")
=======
            .baseUrl("http://test-run-b4d5opbu7a-et.a.run.app/")
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            .baseUrl("http://test-run-b4d5opbu7a-et.a.run.app/")
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            .baseUrl("http://test-run-b4d5opbu7a-et.a.run.app/")
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            .baseUrl("http://test-run-b4d5opbu7a-et.a.run.app/")
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            .baseUrl("http://test-run-b4d5opbu7a-et.a.run.app/")
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}