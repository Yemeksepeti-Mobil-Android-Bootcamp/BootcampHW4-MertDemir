package com.example.bootcamphw4_mertdemr.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.login.LoginRequest
import com.example.bootcamphw4_mertdemr.data.entity.login.LoginResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var yemeksepetiApiRepository: YemeksepetiApiRepository
) : ViewModel() {

    fun login(email: String,password : String): LiveData<Resource<LoginResponse>>{
        val request = LoginRequest(email,password)
        return yemeksepetiApiRepository.login(request)
    }


    fun saveToken(token:Int) {
        yemeksepetiApiRepository.saveToken(token)
    }
}