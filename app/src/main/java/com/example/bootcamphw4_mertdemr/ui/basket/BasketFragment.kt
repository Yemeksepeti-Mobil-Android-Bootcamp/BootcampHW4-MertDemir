package com.example.bootcamphw4_mertdemr.ui.basket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.adapter.BasketAdapter
import com.example.bootcamphw4_mertdemr.data.entity.meal.Category
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponseItem
import com.example.bootcamphw4_mertdemr.databinding.FragmentBasketBinding
import com.example.bootcamphw4_mertdemr.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : Fragment() {

    private lateinit var _binding : FragmentBasketBinding

    private var basketAdapter : BasketAdapter?= null

    private val basketViewModel :BasketViewModel by activityViewModels()

    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true

        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            if(basketAdapter!=null){
                val selectedMeal = basketAdapter!!.basketMealList[layoutPosition]
                basketViewModel.deletFromBasket(selectedMeal)
                basketAdapter!!.notifyDataSetChanged()
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.basketRv.layoutManager = LinearLayoutManager(context)

        ItemTouchHelper(swipeCallBack).attachToRecyclerView(_binding.basketRv)
        _binding.basketRv.adapter = basketAdapter


        Log.e("view","viewcreated")


        basketViewModel.basket.observe(viewLifecycleOwner,{
            Log.e("Observe viewMODEL","Obswrve")


            basketAdapter = BasketAdapter(it)
            _binding.basketRv.adapter = basketAdapter
            basketAdapter!!.notifyDataSetChanged()


        })

        basketViewModel.totalbasket.observe(viewLifecycleOwner, {
            _binding.totalBasket.text = "Toplam Sepet :${it.toInt()} Tl"
        })
    }
}