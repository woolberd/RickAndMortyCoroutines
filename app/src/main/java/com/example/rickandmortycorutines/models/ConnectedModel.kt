package com.example.rickandmortycorutines.models

import com.example.rickandmortycorutines.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class ConnectedModel(
    @SerializedName("location")
    val location: LocationModel,
    @SerializedName("character")
    val character: CharacterModel,
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String
) : IBaseDiffModel
