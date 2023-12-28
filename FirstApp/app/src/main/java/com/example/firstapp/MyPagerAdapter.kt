// MyPagerAdapter.kt
package com.example.firstapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 3 // Number of tabs
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Tab 1"
            1 -> "Tab 2"
            2 -> "Tab 3"
            else -> "Tab 1"
        }
    }
}