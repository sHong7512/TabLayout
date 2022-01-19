package com.shong.tablayout

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    val TAG = "ViewPagerAdapter_TAG"

    companion object{
        private const val NUM_PAGES = 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return Fragment1()
            1 -> return Fragment2()
            2 -> return Fragment3()
            else -> {
                Log.d(TAG,"Position Number ERROR")
                return Fragment1()
            }
        }
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

}