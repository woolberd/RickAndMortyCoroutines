package com.example.rickandmortycorutines.models

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("character and location")
    val characterAndLocationModel: CharacterAndLocationModel
)