package com.example.bootcamphw4_mertdemr.data.entity.customer


import com.google.gson.annotations.SerializedName

data class CustomerByIdResponse(
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("givenOrders")
    val givenOrders: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String
)