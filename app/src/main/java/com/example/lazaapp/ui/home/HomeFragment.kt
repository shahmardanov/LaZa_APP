package com.example.lazaapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.lazaapp.R
import com.example.lazaapp.base.BaseFragment
import com.example.lazaapp.databinding.FragmentHomeBinding
import com.example.lazaapp.newarrival.NewArrivalAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
    private val brandAdapter = HomeAdapter()
    private val newArrivalAdapter = NewArrivalAdapter()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.createBrand()
        binding.rvBrands.adapter = brandAdapter
        binding.rvBrands.adapter = newArrivalAdapter

    }

    private fun observeData() {
        viewModel.brandData.observe(viewLifecycleOwner) {
            brandAdapter.updateList(it)
        }

        viewModel.data.observe(viewLifecycleOwner) {

        }

        viewModel.loading.observe(viewLifecycleOwner) {

        }

        viewModel.error.observe(viewLifecycleOwner) {

        }
    }

}