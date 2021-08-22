package com.example.bootcamphw4_mertdemr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealDetailByIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponse
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponseItem
import com.example.bootcamphw4_mertdemr.databinding.RestorandetailMealRawBinding


class RestoranDetailMealList(val mealList : MealsGetByShopIdResponse,private val listener : Listener): RecyclerView.Adapter<RestoranDetailMealList.MealList>() {





    class MealList(var binding: RestorandetailMealRawBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealList {
       val view = RestorandetailMealRawBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MealList(view)
    }

    override fun onBindViewHolder(holder: MealList, position: Int) {

        holder.binding.mealName.text = mealList!![position].name

        holder.binding.mealPrice.text = mealList!![position].price.toString()

        Glide.with(holder.binding.mealImg.context).load(mealList!![position].imagePath).into(holder.binding.mealImg)

        holder.binding.addMeal.setOnClickListener{
            Toast.makeText(it.context,"Sepete Eklendi ${mealList!!.get(position).name}", Toast.LENGTH_SHORT).show()
            listener?.onItemClick(mealList!![position])

        }

        holder.binding.meallistBackground.setOnClickListener {
            val bundle = bundleOf("mealId" to mealList!![position].id)
            it.findNavController().navigate(R.id.action_restoranDetailFragment_to_mealDetailFragment,bundle)
        }

    }

    override fun getItemCount(): Int {
        return mealList?.size?: 0
    }
    interface Listener {
        fun onItemClick(meal: MealsGetByShopIdResponseItem)
    }
}