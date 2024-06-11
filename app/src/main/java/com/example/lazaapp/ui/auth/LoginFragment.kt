package com.example.lazaapp.ui.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.lazaapp.R
import com.example.lazaapp.base.BaseFragment
import com.example.lazaapp.databinding.FragmentLoginBinding
import com.example.lazaapp.utils.gone
import com.example.lazaapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        binding.button.setOnClickListener {
            login()
        }
    }

    private fun observeData() {
        viewModel.isSuccess.observe(viewLifecycleOwner) {
            if (it) {
                if (binding.switchMaterial.isChecked) setUserAuth()
                Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_LONG).show()
            }
        }


        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) binding.animationView.visible() else binding.animationView.gone()
        }
    }

    private fun login() {
        val userEmail = binding.emailLogin.text.toString().trim()
        val userPassword = binding.passwordLogin.toString().trim()

        if (userEmail.isNotEmpty() && userPassword.isNotEmpty()) {
            viewModel.loginUser(userEmail, userPassword)
        } else {
            Toast.makeText(context, "Setirler bosh ola bilmez", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUserAuth() {
        val sp = requireActivity().getSharedPreferences("product_local", Context.MODE_PRIVATE)
        sp.edit().putBoolean("isAuth", true).apply()
    }
}