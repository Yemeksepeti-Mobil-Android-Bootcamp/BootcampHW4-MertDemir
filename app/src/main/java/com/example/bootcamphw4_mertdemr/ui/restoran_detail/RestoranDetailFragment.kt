package com.example.bootcamphw4_mertdemr.ui.restoran_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.adapter.RestoranDetailMealList
import com.example.bootcamphw4_mertdemr.data.entity.meal.MealsGetByShopIdResponseItem
import com.example.bootcamphw4_mertdemr.databinding.FragmentRestoranDetailBinding
import com.example.bootcamphw4_mertdemr.ui.basket.BasketViewModel
import com.example.bootcamphw4_mertdemr.ui.restoran_list.RestoranListViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestoranDetailFragment : Fragment(),RestoranDetailMealList.Listener {

    private lateinit var _binding : FragmentRestoranDetailBinding
    private  var adapter : RestoranDetailMealList? = null

    private val viewModel: RestoranDetailViewModel by viewModels()
    private val basketViewModel : BasketViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentRestoranDetailBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.mealListRv.layoutManager = LinearLayoutManager(context)
        _binding.mealListRv.adapter = adapter

        val shopId = arguments?.getInt("shopIdforDetail")

        viewModel.shopById(shopId!!).observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranDetail fragment","Loading")
                    _binding.shopImg.visibility = View.GONE
                    _binding.shopHZ.visibility = View.GONE
                }
                Resource.Status.SUCCESS -> {
                    Log.e("RestoranDetail fragment","Succes")

                    _binding.shopImg.visibility = View.VISIBLE
                    _binding.shopHZ.visibility = View.VISIBLE

                    _binding.restorandetailBar.visibility = View.GONE
                    _binding.shopHZ.text = it.data!!.speed.toString()
                    Glide.with(_binding.shopImg.context).load(it.data.imagePath).into(_binding.shopImg)
                    _binding.shopLezzet.text = it.data!!.tasteQuality.toString()
                    _binding.shopServis.text = it.data!!.serviceQuality.toString()
                    _binding.shopMin.text = it.data!!.minPrice
                    _binding.shopMinute.text = it.data!!.serviceTime



                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranDetail fragment","${it.message}")


                }


            }
        })

        viewModel.mealByShopId(shopId).observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranDetail fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("RestoranDetail fragment","Succes")


                    adapter = RestoranDetailMealList(it.data!!,this)
                    _binding.mealListRv.adapter=adapter



                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranDetail fragment","${it.message}")


                }


            }
        })


    }

    override fun onItemClick(meal: MealsGetByShopIdResponseItem) {
        println("${meal.name}")
        Log.e("İtemclicked","${meal.name}")
        basketViewModel.addToBasket(meal)
    }
}