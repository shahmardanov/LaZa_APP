package com.example.lazaapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lazaapp.R
import com.example.lazaapp.model.BrandModel
import dagger.hilt.android.lifecycle.HiltViewModel

class HomeViewModel : ViewModel() {

    val brandData = MutableLiveData<List<BrandModel>>()

    fun createBrand() {
        val brandList = listOf(
            BrandModel(R.drawable.adidas, "Adidas"),
            BrandModel(R.drawable.nike, "Nike"),
            BrandModel(R.drawable.fila, "Fila"),
            BrandModel(R.drawable.new_balance, "New Balance"),
            BrandModel(R.drawable.reebok, "Reebok"))

        brandData.value = brandList
    }
}