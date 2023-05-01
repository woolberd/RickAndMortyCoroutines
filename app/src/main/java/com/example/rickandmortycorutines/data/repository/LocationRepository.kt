package com.example.rickandmortycorutines.data.repository

import com.example.rickandmortycorutines.data.remote.apiservices.LocationApiService
import com.example.rickandmortycorutines.models.LocationModel
import com.example.rickandmortycorutines.models.Response
import com.example.rickandmortycorutines.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService
){
    fun fetchLocation(): Flow<Resource<Response<LocationModel>>> = flow {
        emit(Resource.Loading())
        val fetchLocation = locationApiService.fetchLocation()
        emit(Resource.Success(fetchLocation))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}