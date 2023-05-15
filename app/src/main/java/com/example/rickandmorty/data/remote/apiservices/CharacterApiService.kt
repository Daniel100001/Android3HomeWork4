package com.example.rickandmorty.data.remote.apiservices

import retrofit2.Call
import com.example.rickandmorty.model.CharacterModel
import com.example.rickandmorty.model.RickAndMortyResponse
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>

}