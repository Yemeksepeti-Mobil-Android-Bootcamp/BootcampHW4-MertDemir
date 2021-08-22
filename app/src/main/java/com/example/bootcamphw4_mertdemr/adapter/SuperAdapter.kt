package com.example.bootcamphw4_mertdemr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootcamphw4_mertdemr.data.entity.shop.ShopListResponse
import com.example.bootcamphw4_mertdemr.databinding.RestoranlistRawBinding

class SuperAdapter(): RecyclerView.Adapter<SuperAdapter.SuperHolder>() {

    var shopList : ShopListResponse? =null

    class SuperHolder(var binding : RestoranlistRawBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHolder {
        val view = RestoranlistRawBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHolder, position: Int) {
        holder.binding.serviceTime.text = shopList!![position].serviceTime
        holder.binding.shopMNPrice.text = shopList!![position].minPrice
        holder.binding.shopName.text = shopList!![position].name
        Glide.with(holder.binding.shopImg.context).load(shopList!![position].imagePath).into(holder.binding.shopImg)

    }

    override fun getItemCount(): Int {
        return shopList?.size ?: 0
    }
}