package com.latihan.capstoneproject.api

import com.latihan.capstoneproject.response.LoginResponse
import com.latihan.capstoneproject.response.MapsResponse
import com.latihan.capstoneproject.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name : String?,
        @Field("email") email : String?,
        @Field("password") password : String?
    ): Call<RegisterResponse>

    @GET("stories")
    fun getStoryMaps(
        @Header("Authorization") auth : String,
        @Query("location") location: Int=1
    ): Call<MapsResponse>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
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