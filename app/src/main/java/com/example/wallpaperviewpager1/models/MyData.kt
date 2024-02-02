package com.example.wallpaperviewpager1.models

import com.example.wallpaperviewpager1.R

object MyData {
    fun generateImages(): ArrayList<Int> {

        val list = ArrayList<Int>()

        for (i in 1..20) {
            list.add(R.drawable.img)
        }

        return list
    }
}