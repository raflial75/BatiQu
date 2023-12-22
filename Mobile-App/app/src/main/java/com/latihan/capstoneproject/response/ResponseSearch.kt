package com.latihan.capstoneproject.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseSearch(

    @field:SerializedName("total_count")
    val totalCount: Int? = null,

    @field:SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @field:SerializedName("items")
    val items: List<ItemsItem>? = null
)
@Parcelize
data class ItemsItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("photo")
    val photo: Int,

    @field:SerializedName("address")
    val description: String? = null
) : Parcelable
