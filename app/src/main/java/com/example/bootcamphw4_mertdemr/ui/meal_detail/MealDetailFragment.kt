package com.example.bootcamphw4_mertdemr.ui.meal_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.databinding.FragmentMealDetailBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailFragment : Fragment() {

    private lateinit var _binding : FragmentMealDetailBinding
    private  val viewModel : MealDetailViewModel by viewModels()

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mealId = arguments?.getInt("mealId")
        viewModel.mealDetail(mealId!!).observe(viewLifecycleOwner, {
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranDetail fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("RestoranDetail fragment","Succes")


                    _binding.mealDescription.text = it.data?.explanation.toString()
                    _binding.mealName.text = it.data?.name
                    _binding.price.text = it.data?.price.toString()

                    Glide.with(_binding.mealImg.context).load(it.data?.imagePath).into(_binding.mealImg)




                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranDetail fragment","${it.message}")


                }


            }
        })


    }
}