package com.example.rickandmorty.data.remote.apiservices

import retrofit2.Call
import com.example.rickandmorty.model.CharacterModel
import com.example.rickandmorty.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>

    @GET ("api/character/{id}")
    fun fetchSingleCharacter (
        @Path("id") id: Int
    ): Call<CharacterModel>
}