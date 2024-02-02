package com.example.wallpaperviewpager1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.wallpaperviewpager1.adapters.RvAdapter
import com.example.wallpaperviewpager1.databinding.FragmentImageInfoBinding
import com.example.wallpaperviewpager1.models.Categories

private const val ARG_PARAM1 = "param1"


class ImageInfoFragment : Fragment() {

    private var param1: Categories? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Categories?
        }
    }

    private val binding by lazy { FragmentImageInfoBinding.inflate(layoutInflater) }
    private lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rvAdapter = RvAdapter(param1?.list!!) {
            val bundle = Bundle()
            bundle.putInt("img", it)
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_infoFragment, bundle)
        }
        binding.rv.adapter = rvAdapter


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Categories) =
            ImageInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }

}