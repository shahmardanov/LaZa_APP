package com.example.lazaapp.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.lazaapp.R
import com.example.lazaapp.base.BaseFragment
import com.example.lazaapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forwardFragment()
    }

    private fun forwardFragment() {
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
        }
    }
}