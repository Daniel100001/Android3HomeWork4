package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApiService {
        return retrofitClient.create(CharacterApiService::class.java)
    }
}