package com.example.bootcamphw4_mertdemr.ui.meal_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealDetailByIdResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var yemeksepetiApiRepository: YemeksepetiApiRepository
)  : ViewModel() {

    fun mealDetail(mealId : Int) : LiveData<Resource<MealDetailByIdResponse>>{

        return yemeksepetiApiRepository.mealDetail(mealId)
    }
}