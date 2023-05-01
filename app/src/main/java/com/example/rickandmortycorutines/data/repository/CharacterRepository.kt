package com.example.rickandmortycorutines.data.repository

import com.example.rickandmortycorutines.data.remote.apiservices.CharacterApiService
import com.example.rickandmortycorutines.models.CharacterModel
import com.example.rickandmortycorutines.models.Response
import com.example.rickandmortycorutines.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService
) {
    fun fetchCharacter(): Flow<Resource<Response<CharacterModel>>> = flow {
        emit(Resource.Loading())
        val fetchCharacter = characterApiService.fetchCharacter()
        emit(Resource.Success(fetchCharacter))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}