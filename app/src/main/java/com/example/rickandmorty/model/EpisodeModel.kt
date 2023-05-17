package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel (
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,


    @SerializedName("episode")
    val episode: String
    )