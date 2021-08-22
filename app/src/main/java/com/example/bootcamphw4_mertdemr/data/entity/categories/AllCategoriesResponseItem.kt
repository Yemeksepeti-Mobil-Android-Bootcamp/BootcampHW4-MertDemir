package com.example.bootcamphw4_mertdemr.data.entity.categories


import com.google.gson.annotations.SerializedName

data class AllCategoriesResponseItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("meals")
    val meals: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("shop")
    val shop: Any,
    @SerializedName("shopId")
    val shopId: Int
)