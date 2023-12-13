package com.latihan.capstoneproject.response

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String?,

    @field:SerializedName("loginResult")
    val loginResult: Login
    )

data class Login(
    @field:SerializedName("userId")
    val userId: String?,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("token")
    val token: String?
)