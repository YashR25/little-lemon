package com.example.littlelemon.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext

const val IS_LOGGED_IN = "isLoggedIn"
const val DB_NAME = "Little Lemon DB"
const val FIRST_NAME = "First Name"
const val LAST_NAME = "Last Name"
const val EMAIL = "Email"

object SharedPreferenceManager{
    fun getSharedPreference(context: Context): SharedPreferences? {
        return context.getSharedPreferences(DB_NAME, ComponentActivity.MODE_PRIVATE)
    }
}