package com.example.bootcamphw4_mertdemr.ui.settings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.activity.StartActivity
import com.example.bootcamphw4_mertdemr.databinding.FragmentSettingsBinding
import com.example.bootcamphw4_mertdemr.ui.restoran_list.RestoranListViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private lateinit var _binding : FragmentSettingsBinding
    private val viewModel: SettingsViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.customerById(viewModel.getToken()).observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("RestoranList fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("Catalog fragment","Succes")
                  _binding.firstName.text = it.data!!.firstName
                  _binding.surName.text = it.data!!.lastname
                  _binding.userPhone.text = it.data!!.phone
                  _binding.userAddress.text = it.data!!.address
                  _binding.userEmail.text = it.data!!.email





                }
                Resource.Status.ERROR -> {
                    Log.e("RestoranList fragment","${it.message}")


                }


            }
        })
        _binding.signOutBtn.setOnClickListener{
            if(viewModel.signOut()){
                activity?.let{
                    val intent = Intent(it, StartActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    startActivity(intent)
                    it.finish()
                }
            }

        }


    }
}