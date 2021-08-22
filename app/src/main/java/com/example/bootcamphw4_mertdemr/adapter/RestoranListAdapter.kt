package com.example.bootcamphw4_mertdemr.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.data.entity.shop.ShopListResponse
import com.example.bootcamphw4_mertdemr.databinding.RestoranlistRawBinding

class RestoranListAdapter(): RecyclerView.Adapter<RestoranListAdapter.RestoranViewHolder>() {

        var shopList : ShopListResponse? =null



    class RestoranViewHolder(var binding :RestoranlistRawBinding) :RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoranViewHolder {
        val view = RestoranlistRawBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestoranViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestoranViewHolder, position: Int) {

        holder.binding.serviceTime.text = shopList!![position].serviceTime
        holder.binding.shopMNPrice.text = shopList!![position].minPrice
        holder.binding.shopName.text = shopList!![position].name
        Glide.with(holder.binding.shopImg.context).load(shopList!![position].imagePath).into(holder.binding.shopImg)


        holder.binding.restoranlistBackground.setOnClickListener {

            val bundle = bundleOf("shopIdforDetail" to shopList!![position].id)
            it.findNavController().navigate(R.id.action_restoranListFragment_to_restoranDetailFragment,bundle)
        }

    }

    override fun getItemCount(): Int {
        return shopList?.size ?: 0
    }

}