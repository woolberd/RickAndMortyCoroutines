package com.example.rickandmortycorutines.models

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String
)