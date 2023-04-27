package com.example.rickandmortycorutines.data.repository

import com.example.rickandmortycorutines.data.remote.apiservices.CharacterApiService
import com.example.rickandmortycorutines.data.remote.apiservices.LocationApiService
import com.example.rickandmortycorutines.models.ConnectedModel
import com.example.rickandmortycorutines.models.LocationModel
import com.example.rickandmortycorutines.models.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService
){
    fun fetchLocation(): Flow<Response<LocationModel>> = flow {
        val fetchLocation = locationApiService.fetchLocation()
        emit(fetchLocation)
    }.flowOn(Dispatchers.IO)
}