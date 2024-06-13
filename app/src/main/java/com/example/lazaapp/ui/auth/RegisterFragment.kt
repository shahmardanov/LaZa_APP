package com.example.lazaapp.ui.auth

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lazaapp.R
import com.example.lazaapp.base.BaseFragment
import com.example.lazaapp.databinding.FragmentRegisterBinding
import com.example.lazaapp.utils.gone
import com.example.lazaapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel by viewModels<LoginViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerLazzaButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        var email = binding.emailLogin.text.toString().trim()
        var password = binding.pass1.text.toString().trim()
        var repassword = binding.pass2.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty() && repassword.isNotEmpty()) {
            if (password == repassword) {
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    viewModel.registerUser(email,password)
                    findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                } else {
                    Toast.makeText(context, "The email format is not correct", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "The passwords is not the same", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(context, "The lines should not be empty", Toast.LENGTH_LONG).show()
        }
    }

    private fun observeData() {
        viewModel.isSuccess.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(context, "SignUp Success", Toast.LENGTH_LONG).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            } else {
                Toast.makeText(context, "SignUp Failed", Toast.LENGTH_LONG).show()
            }
        }


        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) binding.animationView.visible() else binding.animationView.gone()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }
}