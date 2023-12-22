package com.latihan.capstoneproject.response

import com.google.gson.annotations.SerializedName

data class ResponseSearchDetail(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("photo")
	val photo: String,

	@field:SerializedName("description")
	val description: String,

)
