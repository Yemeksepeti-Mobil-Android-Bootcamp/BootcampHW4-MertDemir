package com.example.bootcamphw4_mertdemr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamphw4_mertdemr.databinding.AdRawBinding

class AdAdapter(): RecyclerView.Adapter<AdAdapter.AdHolder>() {

    class AdHolder(var binding : AdRawBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdHolder {
       val view = AdRawBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdHolder(view)
    }

    override fun onBindViewHolder(holder: AdHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

}