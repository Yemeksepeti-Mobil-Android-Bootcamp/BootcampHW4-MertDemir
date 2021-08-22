package com.example.bootcamphw4_mertdemr.data.entity.meal


import com.google.gson.annotations.SerializedName

data class AddMealRequest(
    @SerializedName("categoryId")
    val categoryId: Int,
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)