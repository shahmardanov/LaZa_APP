package com.example.lazaapp.di

import com.example.lazaapp.source.remote.ProductService
import com.example.lazaapp.source.remote.Repository
import com.example.lazaapp.utils.BaseUrl
import com.example.lazaapp.utils.BaseUrl.BASE_URL
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Singleton
    @Provides
    fun provideFirebaseauth() :FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideRepository(firebaseAuth: FirebaseAuth, productService: ProductService):Repository {
        return Repository(firebaseAuth,productService)
    }
}