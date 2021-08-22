package com.example.bootcamphw4_mertdemr.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.bootcamphw4_mertdemr.R
import com.example.bootcamphw4_mertdemr.activity.StartActivity

class SlideViewPagerAdapter(private var context : Context) : PagerAdapter() {


    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean =(view==`object`)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var view = LayoutInflater.from(context).inflate(R.layout.slide_screen,null)

        val imageView : ImageView = view.findViewById(R.id.imageView)
        val description : TextView = view.findViewById(R.id.description)
        val yemeksepetilogo : ImageView = view.findViewById(R.id.yemeksepetiView)

        val ind1 : ImageView = view.findViewById(R.id.ind1)
        val ind2 : ImageView = view.findViewById(R.id.ind2)
        val ind3 : ImageView = view.findViewById(R.id.ind3)


        val getstarted : Button = view.findViewById(R.id.start_button)

        getstarted.setOnClickListener {
            val intent = Intent(it.context, StartActivity::class.java)

                context.startActivity(intent)


        }



            when (position){

                0 ->
                {
                    imageView.setImageResource(R.drawable.screen1)
                    description.text ="Türkiyenin en büyük online yemek sipariş uygulaması"

                    ind1.setImageResource(R.drawable.selected)
                    ind2.setImageResource(R.drawable.unselected)
                    ind3.setImageResource(R.drawable.unselected)

                }
                1 ->{


                    imageView.setImageResource(R.drawable.screen2)
                    description.text =""
                    yemeksepetilogo.setVisibility(View.GONE)

                    ind1.setImageResource(R.drawable.unselected)
                    ind2.setImageResource(R.drawable.selected)
                    ind3.setImageResource(R.drawable.unselected)
                }
                2 ->{

                    imageView.setImageResource(R.drawable.screen3)
                    description.text =""

                    ind1.setImageResource(R.drawable.unselected)
                    ind2.setImageResource(R.drawable.unselected)
                    ind3.setImageResource(R.drawable.selected)
                }
            }



        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}