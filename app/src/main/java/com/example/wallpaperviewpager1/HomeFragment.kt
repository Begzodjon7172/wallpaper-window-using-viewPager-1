package com.example.wallpaperviewpager1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpaperviewpager1.adapters.ImagePagerAdapter
import com.example.wallpaperviewpager1.databinding.FragmentHomeBinding
import com.example.wallpaperviewpager1.databinding.ItemTabBinding
import com.example.wallpaperviewpager1.models.Categories
import com.example.wallpaperviewpager1.models.MyData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var imagePagerAdapter: ImagePagerAdapter
    private lateinit var categoryList: ArrayList<Categories>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadData()

        imagePagerAdapter = ImagePagerAdapter(categoryList, parentFragmentManager)
        binding.viewPager.adapter = imagePagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        setTabs()

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabBinding = tab?.customView?.let { ItemTabBinding.bind(it) }
                itemTabBinding?.tvTitle?.setTextColor(Color.WHITE)
                itemTabBinding?.circle?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabBinding = tab?.customView?.let { ItemTabBinding.bind(it) }
                itemTabBinding?.tvTitle?.setTextColor(Color.parseColor("#FFD4D4D5"))
                itemTabBinding?.circle?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        return binding.root
    }

    private fun setTabs() {
        val count = binding.tabLayout.tabCount

        for (i in 0 until count) {
            val tab = binding.tabLayout.getTabAt(i)
            val itemTabBinding = ItemTabBinding.inflate(layoutInflater)
            itemTabBinding.tvTitle.text = categoryList[i].title
            if (i == 0) {
                itemTabBinding.tvTitle.setTextColor(Color.WHITE)
            } else {
                itemTabBinding.tvTitle.setTextColor(Color.parseColor("#FFD4D4D5"))
                itemTabBinding.circle.visibility = View.INVISIBLE
            }
            tab?.setCustomView(itemTabBinding.root)
        }
    }

    private fun loadData() {
        categoryList = ArrayList()
        categoryList.add(Categories("All", MyData.generateImages()))
        categoryList.add(Categories("New", MyData.generateImages()))
        categoryList.add(Categories("Animals", MyData.generateImages()))
        categoryList.add(Categories("Technology", MyData.generateImages()))
        categoryList.add(Categories("Nature", MyData.generateImages()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.viewPager.adapter = null
    }
}