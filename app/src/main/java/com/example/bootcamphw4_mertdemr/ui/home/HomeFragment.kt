package com.example.bootcamphw4_mertdemr.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.adapter.AdAdapter
import com.example.bootcamphw4_mertdemr.adapter.FavoriteAdapter
import com.example.bootcamphw4_mertdemr.adapter.OrderHistoryAdapter
import com.example.bootcamphw4_mertdemr.adapter.SuperAdapter
import com.example.bootcamphw4_mertdemr.databinding.FragmentHomeBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding : FragmentHomeBinding

    private var adAdapter : AdAdapter = AdAdapter()
    private var orderHistoryAdapter : OrderHistoryAdapter = OrderHistoryAdapter()
    private var favoriteAdapter : FavoriteAdapter = FavoriteAdapter()
    private var superAdapter : SuperAdapter = SuperAdapter()

    private val viewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.homeAdRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
        _binding.homeAdRv.adapter = adAdapter

        _binding.orderHistoryRv.layoutManager = LinearLayoutManager(context)
        _binding.orderHistoryRv.adapter = orderHistoryAdapter

        _binding.favoriteRv.layoutManager = LinearLayoutManager(context)
        _binding.favoriteRv.adapter = favoriteAdapter

        _binding.superRv.layoutManager = LinearLayoutManager(context)
        _binding.superRv.adapter = superAdapter

        viewModel.restoranList().observe(viewLifecycleOwner, {
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranList fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("Catalog fragment","Succes")
                    favoriteAdapter.shopList = it.data
                    superAdapter.shopList = it.data
                    favoriteAdapter.notifyDataSetChanged()
                    superAdapter.notifyDataSetChanged()


                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranList fragment","${it.message}")


                }


            }

        })

        viewModel.customerById(viewModel.getToken()).observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranList fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("Catalog fragment","Succes")
                    _binding.homeUserName.text = it.data!!.firstName+" "+it.data!!.lastname







                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranList fragment","${it.message}")


                }


            }
        })
        _binding.homeRestoranlist.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_restoranListFragment)

        }
    }
}