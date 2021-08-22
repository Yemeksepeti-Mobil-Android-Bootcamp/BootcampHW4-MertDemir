package com.example.bootcamphw4_mertdemr.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.databinding.FragmentHomeBinding
import com.example.bootcamphw4_mertdemr.databinding.FragmentRegisterBinding
import com.example.bootcamphw4_mertdemr.ui.login.LoginViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var _binding : FragmentRegisterBinding
    private val viewModel : RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.kayTolBtn.setOnClickListener{
            val name = _binding.registerfirstName.text.toString()
            val surname = _binding.registerSurname.text.toString()
            val adress = _binding.registerAddress.text.toString()
            val email = _binding.registerEmail.text.toString()
            val password = _binding.registerParola.text.toString()
            val phone = _binding.registerTelefon.text.toString()

            viewModel.register(name,surname,adress,email,password,phone).observe(viewLifecycleOwner, {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
               /* when (it.status) {
                    Resource.Status.LOADING -> {
                        Log.e("Register Fragment","Loading")
                    }
                    Resource.Status.SUCCESS -> {
                        Log.e("Register Fragment","Succes")
                       findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    }
                    Resource.Status.ERROR -> {
                        Log.e("Register Fragment","Error")
                    }
                }*/
            })

        }
    }
}