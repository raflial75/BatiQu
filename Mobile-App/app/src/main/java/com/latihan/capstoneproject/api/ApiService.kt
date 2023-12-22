package com.latihan.capstoneproject.api

import com.latihan.capstoneproject.response.ItemsItem
import com.latihan.capstoneproject.response.LoginResponse
import com.latihan.capstoneproject.response.RegisterResponse
import com.latihan.capstoneproject.response.ResponseSearch
import com.latihan.capstoneproject.response.ResponseSearchDetail
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


    @GET("favourite/{name}")
    fun getnameDetail(
        @Path("name") name: String
    ): Call<ResponseSearchDetail>

    @GET("favourite/{address}")
    fun getaddressDetail(
        @Path("address") address: String
    ): Call<ResponseSearchDetail>

    @GET("favourite/{photo}")
    fun getphotoDetail(
        @Path("photo") photo: String
    ): Call<ResponseSearchDetail>

    @GET("favourite/{description}")
    fun getdescriptionDetail(
        @Path("description") description: String
    ): Call<ResponseSearchDetail>

    @GET("favourite/{name}")
    fun getname(
        @Path("name") name: String?
    ): Call<List<ItemsItem>>

    @GET("favourite/{address}")
    fun getaddress(
        @Path("username") address: String?
    ): Call<List<ItemsItem>>

    @GET("favourite/{photo}")
    fun getphoto(
        @Path("photo") photo: String?
    ): Call<List<ItemsItem>>

    @GET("favourite/{description}")
    fun getdescription(
        @Path("description") description: String?
    ): Call<List<ItemsItem>>
}