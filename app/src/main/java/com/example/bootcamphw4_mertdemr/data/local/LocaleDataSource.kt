package com.example.bootcamphw4_mertdemr.data.local

import javax.inject.Inject

class LocaleDataSource @Inject constructor(
    val sharedPrefManager: SharedPrefManager
) {

    fun saveToken(token: Int) {
        sharedPrefManager.saveToken(token)
    }

    fun getToken(): Int? {
        return sharedPrefManager.getToken()
    }
}
