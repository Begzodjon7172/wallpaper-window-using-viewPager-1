package com.example.wallpaperviewpager1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.wallpaperviewpager1.ImageInfoFragment
import com.example.wallpaperviewpager1.models.Categories

class ImagePagerAdapter(var list: ArrayList<Categories>, var fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ImageInfoFragment.newInstance(list[position])
    }
}