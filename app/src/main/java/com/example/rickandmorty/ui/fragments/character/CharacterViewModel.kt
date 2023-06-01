package com.example.rickandmorty.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.CharacterRepository
import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.models.RickAndMortyResponse


class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()
    private val _characterLiveData = MutableLiveData<RickAndMortyResponse<CharacterModel>>()
    val characterLiveData: LiveData<RickAndMortyResponse<CharacterModel>> get() = _characterLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun fetchSingleCharacter(id: Int): LiveData<CharacterModel> {
        return characterRepository.fetchSingleCharacter(id)
    }

    fun fetchCharacters(
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String
    ) {
        characterRepository.fetchCharacter(
            name = name,
            status = status,
            species = species,
            type = type,
            gender = gender,
            onResponse = { data ->
                _characterLiveData.value = data
            },
            onFailure = { message ->
                _errorLiveData.value = message
            }
        )
    }
}