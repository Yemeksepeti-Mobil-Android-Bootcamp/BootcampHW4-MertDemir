package com.example.bootcamphw4_mertdemr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealDetailByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponseItem
import com.example.bootcamphw4_mertdemr.databinding.BasketRawBinding

class BasketAdapter(val basketMealList : List<MealsGetByShopIdResponseItem>): RecyclerView.Adapter<BasketAdapter.BasketHolder>() {



    class BasketHolder(var binding : BasketRawBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val view = BasketRawBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BasketHolder(view)
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {

        holder.binding.mealName.text = basketMealList!![position].name
        holder.binding.orderPrice.text = basketMealList!![position].price.toString()
        holder.binding.mealQuantity.text = basketMealList[position].count.toString()


    }

    override fun getItemCount(): Int {
        return basketMealList.size
    }
}