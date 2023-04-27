package com.example.rickandmortycorutines.di

import com.example.rickandmortycorutines.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun fetchLocation() = retrofitClient.fetchLocation()

    @Singleton
    @Provides
    fun fetchCharacter() =  retrofitClient.fetchCharacter()
}