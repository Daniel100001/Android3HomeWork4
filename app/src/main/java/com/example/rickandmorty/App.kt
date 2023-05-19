package com.example.rickandmorty

import com.example.rickandmorty.data.remote.apiservices.EpisodeApiService
import android.app.Application
import com.example.rickandmorty.data.remote.RetrofitClient
import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty.data.remote.apiservices.LocationApiService

class App : Application() {

    companion object {
        var characterApi: CharacterApiService? = null
        var locationApi: LocationApiService? = null
        var episodeApi: EpisodeApiService? = null
    }

    override fun onCreate() {
        super.onCreate()

        val retrofitClient = RetrofitClient()
        characterApi = retrofitClient.provideCharacterApiService()
        locationApi = retrofitClient.provideLocationApiService()
        episodeApi= retrofitClient.provideEpisodeApiService()
    }
}