package com.example.bootcamphw4_mertdemr.data.remote

import com.example.bootcamphw4_mertdemr.data.entity.categories.AllCategoriesResponse
import com.example.bootcamphw4_mertdemr.data.entity.customer.CustomerByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.login.LoginRequest
import com.example.bootcamphw4_mertdemr.data.entity.login.LoginResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealDetailByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealListResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.register.RegisterRequest
import com.example.bootcamphw4_mertdemr.data.entity.register.RegisterResponse
import com.example.bootcamphw4_mertdemr.data.entity.shop.ShopByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.shop.ShopListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface YemeksepetiApiService {

@POST("api/Auth/LoginCustomer")
suspend fun login(@Body request: LoginRequest) : Response<LoginResponse>

@POST("api/Auth/RegisterCustomer")
suspend fun register(@Body request : RegisterRequest) : Response<RegisterResponse>

@GET("api/Categories/GetList")
suspend fun allCategories() : Response<AllCategoriesResponse>

@GET("api/Meals/GetList")
suspend fun mealList() : Response<MealListResponse>

@GET("api/Meals/GetDetail")
suspend fun mealDetail(@Query("id") id : Int) :Response<MealDetailByIdResponse>

@GET("api/Meals/GetMealsByShop")
suspend fun mealByShopId(@Query("id") id :Int): Response<MealsGetByShopIdResponse>

@GET("api/Shop/GetShopList")
suspend fun shopList():Response<ShopListResponse>

@GET("api/Shop/GetDetail")
suspend fun shopById(@Query("id")id :Int) : Response<ShopByIdResponse>

@GET("api/Customer/GetById")
suspend fun customerById(@Query("id")id : Int) : Response<CustomerByIdResponse>
}