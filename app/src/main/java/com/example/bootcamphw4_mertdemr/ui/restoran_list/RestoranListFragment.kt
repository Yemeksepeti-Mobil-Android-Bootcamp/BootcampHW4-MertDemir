package com.example.bootcamphw4_mertdemr.ui.restoran_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.adapter.RestoranListAdapter
import com.example.bootcamphw4_mertdemr.databinding.FragmentRestoranDetailBinding
import com.example.bootcamphw4_mertdemr.databinding.FragmentRestoranListBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestoranListFragment : Fragment() {

    private lateinit var _binding : FragmentRestoranListBinding
    private  var adapter : RestoranListAdapter = RestoranListAdapter()
    private val viewModel: RestoranListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentRestoranListBinding.inflate(inflater, container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.RestoranListRv.layoutManager = LinearLayoutManager(context)
        _binding.RestoranListRv.adapter = adapter

        viewModel.restoranList().observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranList fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("Catalog fragment","Succes")
                    adapter.shopList = it.data
                    //_binding.CatalogProgressBar.visibility = View.GONE
                    adapter.notifyDataSetChanged()


                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranList fragment","${it.message}")


                }


            }
        })
    }
}