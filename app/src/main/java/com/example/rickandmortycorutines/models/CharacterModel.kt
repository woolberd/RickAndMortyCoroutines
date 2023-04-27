package com.example.rickandmortycorutines.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("image")
    val image: String,
)
