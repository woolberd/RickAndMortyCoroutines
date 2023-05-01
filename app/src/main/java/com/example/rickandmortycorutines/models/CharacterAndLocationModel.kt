package com.example.rickandmortycorutines.models

import com.example.rickandmortycorutines.base.IBaseDiffModel

data class CharacterAndLocationModel(
    val character: CharacterModel,
    val location: LocationModel,
    override val id: Int = 0,
) : IBaseDiffModel
