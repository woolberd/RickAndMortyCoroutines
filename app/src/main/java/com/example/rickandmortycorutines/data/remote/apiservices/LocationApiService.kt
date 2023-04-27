package com.example.rickandmortycorutines.data.remote.apiservices

import com.example.rickandmortycorutines.models.LocationModel
import com.example.rickandmortycorutines.models.Response
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(
    ): Response<LocationModel>
}