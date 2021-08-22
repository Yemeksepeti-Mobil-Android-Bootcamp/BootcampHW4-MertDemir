package com.example.bootcamphw4_mertdemr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamphw4_mertdemr.databinding.OrderHistoryRawBinding

class OrderHistoryAdapter() : RecyclerView.Adapter<OrderHistoryAdapter.OrderHolder>() {

    class OrderHolder(var binding : OrderHistoryRawBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val view = OrderHistoryRawBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OrderHolder(view)
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }
}