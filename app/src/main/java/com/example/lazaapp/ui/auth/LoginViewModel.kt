package com.example.lazaapp.ui.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazaapp.source.remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var loading = MutableLiveData<Boolean>()
    var isSuccess = MutableLiveData<Boolean>()

    fun loginUser(userEmail: String, userPassword: String) {
        loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.loginUser(userEmail, userPassword)
                if (!response.user?.email.isNullOrEmpty()) {
                    loading.value = false
                    isSuccess.value = true
                }
            } catch (e: Exception) {
                loading.value = false
                isSuccess.value = false
            }
        }
    }
}