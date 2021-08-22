package com.example.bootcamphw4_mertdemr.data.entity.meal


import com.google.gson.annotations.SerializedName

data class MealListResponseItem(
    @SerializedName("category")
    val category: Any,
    @SerializedName("categoryId")
    val categoryId: Int,
    @SerializedName("explanation")
    val explanation: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double
)