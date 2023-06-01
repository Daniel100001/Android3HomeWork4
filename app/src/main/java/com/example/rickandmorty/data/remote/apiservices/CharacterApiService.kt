package com.example.rickandmorty.data.remote.apiservices

import retrofit2.Call
import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(
        @Query("name") name: String,
        @Query("status") status: String,
        @Query("species") species: String,
        @Query("type") type: String,
        @Query("gender") gender: String
    ): Call<RickAndMortyResponse<CharacterModel>>

    @GET ("api/character/{id}")
    fun fetchSingleCharacter (
        @Path("id") id: Int
    ): Call<CharacterModel>
}