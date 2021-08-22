package com.example.bootcamphw4_mertdemr.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.data.local.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        if(getToken()!=0){
            Log.v("token kontrol",getToken().toString())
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            super.finish()
            finish()
        }
    }

    private fun getToken() : Int?{
        return SharedPrefManager(applicationContext).getToken()
    }
}