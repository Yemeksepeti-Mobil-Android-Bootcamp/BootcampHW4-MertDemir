package com.example.bootcamphw4_mertdemr.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    companion object {
        const val TOKEN = "com.example.yemeksepeti_mobil_android_teame_hw3.TOKEN"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)

    fun saveToken(token: Int) {
        sharedPreferences.edit().putInt(TOKEN, token).apply()
    }

    fun getToken(): Int? {
        return sharedPreferences.getInt(TOKEN, 0)

    }

}