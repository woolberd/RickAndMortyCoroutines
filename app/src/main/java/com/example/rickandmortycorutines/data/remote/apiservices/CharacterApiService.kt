package com.example.rickandmortycorutines.data.remote.apiservices

import com.example.rickandmortycorutines.models.CharacterModel
import com.example.rickandmortycorutines.models.Response
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacter(
    ): Response<CharacterModel>
}