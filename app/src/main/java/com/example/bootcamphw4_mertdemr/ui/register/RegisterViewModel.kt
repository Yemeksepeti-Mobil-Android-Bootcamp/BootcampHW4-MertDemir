package com.example.bootcamphw4_mertdemr.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.register.RegisterRequest
import com.example.bootcamphw4_mertdemr.data.entity.register.RegisterResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
 class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var yemeksepetiApiRepository: YemeksepetiApiRepository
) : ViewModel() {

    fun register(name:String,
                          surName : String,
                          adress : String,
                          email:String,
                          password:String,
                          phone:String
    ): LiveData<Resource<RegisterResponse>>{
        val request = RegisterRequest(adress,email,name,password,phone,surName)
        return yemeksepetiApiRepository.register(request)
    }




}