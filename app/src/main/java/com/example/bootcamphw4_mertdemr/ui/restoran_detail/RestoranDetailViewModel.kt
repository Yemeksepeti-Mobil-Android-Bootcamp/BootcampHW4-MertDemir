package com.example.bootcamphw4_mertdemr.ui.restoran_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.shop.ShopByIdResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestoranDetailViewModel@Inject constructor(
    savedStateHandle: SavedStateHandle,
    var yemeksepetiApiRepository: YemeksepetiApiRepository
)  : ViewModel() {

    fun shopById(shopId : Int): LiveData<Resource<ShopByIdResponse>>{

        return yemeksepetiApiRepository.shopById(shopId)
    }

    fun mealByShopId(shopId : Int) : LiveData<Resource<MealsGetByShopIdResponse>>{
        return yemeksepetiApiRepository.mealByShopId(shopId)
    }
}