package com.example.bootcamphw4_mertdemr.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.customer.CustomerByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.shop.ShopListResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var yemeksepetiApiRepository: YemeksepetiApiRepository
) : ViewModel()
{
    fun restoranList() : LiveData<Resource<ShopListResponse>> {

        return yemeksepetiApiRepository.shopList()
    }

    fun customerById(customerId : Int) : LiveData<Resource<CustomerByIdResponse>>{
        return yemeksepetiApiRepository.customerById(customerId)
    }
    fun getToken() : Int {

        yemeksepetiApiRepository.checkToken()?.let{

            return it
        }
        return 0
    }


}