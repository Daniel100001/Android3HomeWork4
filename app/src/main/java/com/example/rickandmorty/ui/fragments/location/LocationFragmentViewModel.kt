package com.example.rickandmorty.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.App
import com.example.rickandmorty.models.LocationModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationFragmentViewModel : ViewModel() {

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<LocationModel>?> {
        val data = MutableLiveData<RickAndMortyResponse<LocationModel>?>()

        App.locationApi?.fetchCharactersLocation()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}