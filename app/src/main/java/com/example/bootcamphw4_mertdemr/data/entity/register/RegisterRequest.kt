package com.example.bootcamphw4_mertdemr.data.entity.register


import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("surname")
    val surname: String
)