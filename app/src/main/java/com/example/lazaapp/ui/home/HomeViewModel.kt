package com.example.lazaapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazaapp.R
import com.example.lazaapp.model.BrandModel
import com.example.lazaapp.source.remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val brandData = MutableLiveData<List<BrandModel>>()

    init {
        getInitData()
    }

    private fun getInitData() {
        createBrand()
        getProducts()
    }

    fun createBrand() {
        val brandList = listOf(
            BrandModel(R.drawable.adidas, "Adidas"),
            BrandModel(R.drawable.nike, "Nike"),
            BrandModel(R.drawable.fila, "Fila"),
            BrandModel(R.drawable.new_balance, "New Balance"),
            BrandModel(R.drawable.reebok, "Reebok")
        )

        brandData.value = brandList
    }

    private fun getProducts() {
        viewModelScope.launch {
            val response = repository.getAllProducts()
            if (response.isSuccessful) {
                response.body()?.let {

                }
            }
        }
    }
}