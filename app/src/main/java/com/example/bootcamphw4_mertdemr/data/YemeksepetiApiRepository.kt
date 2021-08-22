package com.example.bootcamphw4_mertdemr.data

import com.example.bootcamphw4_mertdemr.data.entity.login.LoginRequest
import com.example.bootcamphw4_mertdemr.data.entity.register.RegisterRequest
import com.example.bootcamphw4_mertdemr.data.local.LocaleDataSource
import com.example.bootcamphw4_mertdemr.data.remote.RemoteDataSource
import com.example.yemeksepeti_mobil_android_teame_hw3.util.performAuthTokenNetworkOperation
import com.example.yemeksepeti_mobil_android_teame_hw3.util.performNetworkOperation
import javax.inject.Inject

class YemeksepetiApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localeDataSource: LocaleDataSource

) {

fun login( loginRequest : LoginRequest) = performAuthTokenNetworkOperation(
    call = {
        remoteDataSource.login(loginRequest)},
    save = {
        localeDataSource.saveToken(it)
    }
)
    fun signOut() = localeDataSource.saveToken(0)

    fun checkToken(): Int? {
        return localeDataSource.getToken()
    }

    fun saveToken(token:Int) = localeDataSource.saveToken(token)

    fun register(registerRequest : RegisterRequest) = performNetworkOperation {
        remoteDataSource.register(registerRequest)
    }

    fun allCategories()= performNetworkOperation {

        remoteDataSource.allCategories()
    }

    fun mealList() = performNetworkOperation {
        remoteDataSource.mealList()
    }

    fun mealDetail(request : Int) = performNetworkOperation {
        remoteDataSource.mealDetail(request)
    }

    fun mealByShopId(request : Int) = performNetworkOperation {
        remoteDataSource.mealByShopId(request)
    }

    fun shopList() = performNetworkOperation {
        remoteDataSource.shopList()
    }

    fun shopById(request : Int) = performNetworkOperation{
        remoteDataSource.shopById(request)
    }

    fun customerById(request : Int ) =performNetworkOperation {
        remoteDataSource.customerById(request)
    }

}