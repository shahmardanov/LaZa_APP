package com.example.lazaapp.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazaapp.source.remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun loginUser(userEmail: String, userPassword: String) {
        viewModelScope.launch {
            try {
                val response = repository.loginUser(userEmail, userPassword)
                Log.e("responseData", response.user?.email.toString())
            } catch (e: Exception) {
                Log.e("responseError", e.localizedMessage.toString())
            }
        }
    }
}