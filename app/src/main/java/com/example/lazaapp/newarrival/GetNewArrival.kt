package com.example.lazaapp.newarrival

import com.example.lazaapp.source.remote.Repository
import javax.inject.Inject

class GetNewArrival @Inject constructor(private val productRepository: Repository) {

    suspend fun execute() = productRepository.getNewArrivalProduct()
}