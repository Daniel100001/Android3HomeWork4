package com.example.rickandmorty.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.App
import com.example.rickandmorty.model.EpisodeModel
import com.example.rickandmorty.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeFragmentViewModel : ViewModel() {

    fun fetchCharactersEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>?> {
        val data = MutableLiveData<RickAndMortyResponse<EpisodeModel>?>()

        App.episodeApi?.fetchEpisode()
            ?.enqueue(object : Callback<RickAndMortyResponse<EpisodeModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>, t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}