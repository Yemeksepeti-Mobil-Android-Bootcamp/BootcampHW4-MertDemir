package com.example.bootcamphw4_mertdemr.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.view.size
import androidx.viewpager.widget.ViewPager
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.adapter.SlideViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class SlideActivity : AppCompatActivity() {

    var viewPagerAdapter : SlideViewPagerAdapter? =null
    open var viewPager : ViewPager? = null
    var next : ImageView? = null
    var back : ImageView? = null
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        viewPager = findViewById(R.id.ViewPager)
        viewPagerAdapter = SlideViewPagerAdapter(this)
        viewPager!!.setAdapter(viewPagerAdapter)

        if(isOpened()){

            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
            val editor = sharedPreferences!!.edit()
            editor.putBoolean("isFirstTime", true)
            editor.apply()
        }

        next = findViewById(R.id.next_btn)
        back = findViewById(R.id.back_btn)



        next!!.setOnClickListener {


            var position = viewPager!!.currentItem

        viewPager!!.currentItem = position+1
            Log.e("Viewpager size",viewPager!!.size.toString())




        }

        back!!.setOnClickListener{
            var position = viewPager!!.currentItem
            viewPager!!.currentItem = position-1
        }


    }

    private fun isOpened(): Boolean {

        var sharedPreferences : SharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTime",false)

    }
}