package com.latihan.capstoneproject.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batik(
    val name: String,
    val address: String,
    val photo: String,
    val description: String = ""
) : Parcelable