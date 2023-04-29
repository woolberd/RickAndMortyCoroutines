package com.example.rickandmortycorutines.data.repository

import com.example.rickandmortycorutines.data.remote.apiservices.CharacterApiService
import com.example.rickandmortycorutines.data.remote.apiservices.LocationApiService
import com.example.rickandmortycorutines.models.CharacterModel
import com.example.rickandmortycorutines.models.ConnectedModel
import com.example.rickandmortycorutines.models.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService
){
    fun fetchCharacter(): Flow<Response<CharacterModel>> = flow {
        val fetchCharacter = characterApiService.fetchCharacter()
        emit(fetchCharacter)
    }.flowOn(Dispatchers.IO)
}