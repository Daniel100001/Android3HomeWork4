package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.data.remote.RetrofitClient
import com.example.rickandmorty.data.remote.apiservices.CharacterApiService

class App : Application() {

    companion object {
        var characterApi: CharacterApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitClient = RetrofitClient( )
        characterApi = retrofitClient.provideCharacterApiService()
    }
}