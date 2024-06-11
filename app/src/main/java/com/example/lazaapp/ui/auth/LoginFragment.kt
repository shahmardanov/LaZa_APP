package com.example.lazaapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.lazaapp.R
import com.example.lazaapp.base.BaseFragment
import com.example.lazaapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            login()
        }
    }

    private fun observeData() {
        viewModel.isSuccess.observe(viewLifecycleOwner) {
            if (it) Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show() else
                Toast.makeText(context, "Login Failed", Toast.LENGTH_LONG).show()
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
}