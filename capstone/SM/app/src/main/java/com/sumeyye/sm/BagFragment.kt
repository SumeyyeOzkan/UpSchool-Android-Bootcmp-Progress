package com.sumeyye.sm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sumeyye.sm.basket.ClothesBasketAdapter
import com.sumeyye.sm.basket.ClothesBasketFragmentViewModel
import com.sumeyye.sm.databinding.FragmentBagBinding
import com.sumeyye.sm.model.ClothesBasketRoomModel

class BagFragment : Fragment() {

    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { ClothesBasketFragmentViewModel(requireContext()) }

    private val clothesBasketAdapter by lazy { ClothesBasketAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bag, container, false)
        return binding.root
    }

}