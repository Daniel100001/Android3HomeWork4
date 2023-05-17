package com.example.rickandmorty.data.remote.apiservices

import com.example.rickandmorty.model.LocationModel
import com.example.rickandmorty.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    fun fetchCharactersLocation(): Call<RickAndMortyResponse<LocationModel>>

}