package com.example.bootcamphw4_mertdemr.data.entity.meal


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("meals")
    val meals: List<Meal>,
    @SerializedName("name")
    val name: String,
    @SerializedName("shop")
    val shop: Shop,
    @SerializedName("shopId")
    val shopId: Int
)