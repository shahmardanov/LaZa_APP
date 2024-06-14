package com.example.lazaapp.source.remote

import com.example.lazaapp.base.NetworkResponse
import com.example.lazaapp.model.ProductResponse
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

 class Repository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val productService: ProductService
) {

    suspend fun loginUser(userEmail: String, userPassword: String) =
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).await()

    suspend fun registerUser(userEmail: String, userPassword: String) =
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).await()

    suspend fun getAllProducts() = productService.getAllProducts()
}