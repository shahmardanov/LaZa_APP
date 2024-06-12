package com.example.lazaapp.source.remote

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class Repository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    suspend fun loginUser(userEmail: String, userPassword: String) =
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).await()

    suspend fun registerUser(userEmail: String, userPassword: String) =
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).await()
}