package com.shong.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewPager2 : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2= findViewById(R.id.viewPager2)
        viewPager2.adapter = ViewPagerAdapter(this)

        val tabElement = arrayOf("첫번째", "두번째", "세번쩨")
        val tabLayout = findViewById<TabLayout>(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
            tab.text = tabElement.get(position)
        }.attach()

    }

    override fun onBackPressed() {
        if(viewPager2.currentItem == 0) {
            super.onBackPressed()
        }else {
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

}