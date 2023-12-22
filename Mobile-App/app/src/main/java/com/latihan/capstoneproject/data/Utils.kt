package com.latihan.capstoneproject.data

import android.text.TextUtils
import android.util.Patterns

private const val FILENAME_FORMAT = "dd-MMM-yyyy"

fun isValidEmail(email: String): Boolean {
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun validateMinLegth(password: String): Boolean {
    return !TextUtils.isEmpty(password) && password.length >= CekPass.MIN_LENGTH_PASSWORD
}