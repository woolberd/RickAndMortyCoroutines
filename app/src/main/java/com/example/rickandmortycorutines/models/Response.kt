package com.example.rickandmortycorutines.models

import com.example.rickandmortycorutines.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("results")
    val results: List<T>
)