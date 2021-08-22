package com.example.bootcamphw4_mertdemr.ui.basket

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealDetailByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var yemeksepetiApiRepository: YemeksepetiApiRepository
) : ViewModel()
{
    val basket = MutableLiveData<List<MealsGetByShopIdResponseItem>>()
    val totalbasket = MutableLiveData<Double>()

    fun addToBasket(meal : MealsGetByShopIdResponseItem){

        Log.e("VİEW Model","${meal.name}")

        if(basket.value!=null){

            val arrayList =ArrayList(basket.value)

            if(arrayList.contains(meal)){

                val indexOfFirst = arrayList.indexOfFirst { it == meal }
                val relatedMeal = arrayList[indexOfFirst]
                relatedMeal.count += 1
                basket.value = arrayList

            }else{
                meal.count+=1
                arrayList.add(meal)
                basket.value=arrayList
                for (i in arrayList){
                    Log.e("Add to Basket","${i.name}")
                }
            }



        }else{
            val arrayList = arrayListOf(meal)
            meal.count+=1
            basket.value = arrayList


        }

        basket.value?.let {
            refreshTotalValue(it)
        }
    }

    fun deletFromBasket(meal : MealsGetByShopIdResponseItem){

        if(basket.value!=null){
            val arraylist = ArrayList(basket.value)
            arraylist.remove(meal)
            basket.value = arraylist
            refreshTotalValue(arraylist)

        }
    }
    private fun refreshTotalValue(list : List<MealsGetByShopIdResponseItem>){

        var total = 0.0
        list.forEach{ meal ->
            val price = meal.price
            price?.let{

                val revenue = meal.count * it
                total += revenue
            }

        }
        totalbasket.value = total
    }
}