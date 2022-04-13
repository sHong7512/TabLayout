package com.shong.tablayout

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
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
            if(position == 2){
                tab.customView = getTabView()
            }
        }.attach()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                cnt++
                if (this@MainActivity::customCountTextView.isInitialized) {
                    customCountTextView.text = "$cnt"
                }
            }
        })

    }

    override fun onBackPressed() {
        if(viewPager2.currentItem == 0) {
            super.onBackPressed()
        }else {
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

    var cnt = 0
    lateinit var customCountTextView: TextView
    fun getTabView(): View {
        val view: View = layoutInflater.inflate(R.layout.tab_custom, null)
        customCountTextView = view.findViewById(R.id.customCountTextView)
        return view
    }

}