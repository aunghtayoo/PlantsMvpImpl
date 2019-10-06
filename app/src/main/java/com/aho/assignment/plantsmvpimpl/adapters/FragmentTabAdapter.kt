package com.aho.assignment.plantsmvpimpl.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.aho.assignment.plantsmvpimpl.fragments.RecentFavouriteListFragment

class FragmentTabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return RecentFavouriteListFragment()
            1 -> return RecentFavouriteListFragment()
            2 -> return RecentFavouriteListFragment()
            3 -> return RecentFavouriteListFragment()
            else -> return RecentFavouriteListFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position){
            0 -> return "Recent"
            1 -> return "Old"
            2 -> return "Color"
            3 -> return "Album"
            else -> return "Recent"
        }
    }

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

    override fun getCount(): Int {
        return 4
    }
}