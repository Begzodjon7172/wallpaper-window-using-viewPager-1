package com.example.wallpaperviewpager1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpaperviewpager1.databinding.FragmentInfoBinding

private const val ARG_PARAM1 = "img"

class InfoFragment : Fragment() {

    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    private val binding by lazy { FragmentInfoBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        param1?.let { binding.img.setImageResource(it) }

        return binding.root
    }

}