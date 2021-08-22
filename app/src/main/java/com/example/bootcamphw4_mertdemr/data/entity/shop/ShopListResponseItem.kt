package com.example.bootcamphw4_mertdemr.data.entity.shop


import com.google.gson.annotations.SerializedName

data class ShopListResponseItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagePath")
    val imagePath: Any,
    @SerializedName("minPrice")
    val minPrice: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("recievedOrders")
    val recievedOrders: List<Any>,
    @SerializedName("serviceQuality")
    val serviceQuality: Double,
    @SerializedName("serviceTime")
    val serviceTime: String,
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("tasteQuality")
    val tasteQuality: Double
)