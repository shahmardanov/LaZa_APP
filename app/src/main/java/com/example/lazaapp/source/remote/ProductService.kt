package com.example.lazaapp.source.remote

import com.example.lazaapp.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getAllProducts():Response<List<ProductResponse>>{

    }
}