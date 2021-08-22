package com.example.bootcamphw4_mertdemr.ui.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.activity.MainActivity
import com.example.bootcamphw4_mertdemr.databinding.FragmentLoginBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {


    private lateinit var _binding : FragmentLoginBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        _binding.buttonGiris.setOnClickListener{

            val email = _binding.editTextEmail.text.toString()
            val password = _binding.editTextParola.text.toString()


            viewModel.login(email, password).observe(viewLifecycleOwner,{

                when (it.status)
                {
                    Resource.Status.LOADING -> {
                        Log.e("RestoranDetail fragment","Loading")

                    }
                    Resource.Status.SUCCESS -> {
                        Log.e("RestoranDetail fragment","Succes")


                        viewModel.saveToken(it.data!!.id)
                        val intent = Intent(context, MainActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()


                    }
                    Resource.Status.ERROR -> {


                        val dialog = AlertDialog.Builder(context)
                            .setTitle("Error")
                            .setMessage("${it.message}")
                            .setPositiveButton("ok") { dialog, button ->
                                dialog.dismiss()
                            }
                        dialog.show()


                    }


                }


            })

        }
        _binding.buttonKayT.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}