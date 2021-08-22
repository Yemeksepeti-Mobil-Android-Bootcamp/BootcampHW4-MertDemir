package com.example.bootcamphw4_mertdemr.data.remote

import com.example.bootcamphw4_mertdemr.data.entity.login.LoginRequest
import com.example.bootcamphw4_mertdemr.data.entity.register.RegisterRequest
import com.example.bootcamphw4_mertdemr.util.BaseDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val yemeksepetilApiService: YemeksepetiApiService
): BaseDataSource() {

    suspend fun login(request: LoginRequest) = getResult{ yemeksepetilApiService.login(request)}

    suspend fun register(request : RegisterRequest) = getResult{yemeksepetilApiService.register(request)}

    suspend fun allCategories() = getResult { yemeksepetilApiService.allCategories() }

    suspend fun mealList() = getResult{yemeksepetilApiService.mealList()}

    suspend fun mealDetail(request : Int) = getResult{yemeksepetilApiService.mealDetail(request)}

    suspend fun mealByShopId(request : Int) = getResult{yemeksepetilApiService.mealByShopId(request)}

    suspend fun shopList() = getResult{yemeksepetilApiService.shopList()}

    suspend fun shopById(request: Int) = getResult{yemeksepetilApiService.shopById(request)}

    suspend fun customerById(request : Int) = getResult{yemeksepetilApiService.customerById(request)}



}