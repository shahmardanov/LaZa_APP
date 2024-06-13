package com.example.lazaapp.ui.splash

import android.content.Context
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
            val isAuth = getAuth()
            delay(1500)
            if (isAuth) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }
        }
    }

        private fun getAuth(): Boolean {
            val sp = requireActivity().getSharedPreferences("product_local", Context.MODE_PRIVATE)

            return sp.getBoolean("isAuth", false)
        }
    }
