package com.example.rickandmorty.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.App
import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    fun fetchCharacter(
        name : String,
        status: String,
        species: String,
        type : String,
        gender: String,
        onResponse: (data: RickAndMortyResponse<CharacterModel>) -> Unit,
        onFailure: (errorMassage: String) -> Unit
    ) {
        App.characterApi?.fetchCharacters(name = name,status = status,species = species, type = type, gender = gender)
            ?.enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        onResponse(response.body()!!)
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    onFailure(t.localizedMessage ?: "Error")
                }

            })
    }

    fun fetchSingleCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApi?.fetchSingleCharacter(id)?.enqueue(object : Callback<CharacterModel> {

            override fun onResponse(
                call: Call<CharacterModel>,
                response: Response<CharacterModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()
                }

            }

            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                data.value = null
                Log.e("error", t.localizedMessage ?: "Error")
            }

        })
        return data
    }
}