package com.example.rickandmorty.data.remote.apiservices

import com.example.rickandmorty.model.EpisodeModel
import com.example.rickandmorty.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>

}