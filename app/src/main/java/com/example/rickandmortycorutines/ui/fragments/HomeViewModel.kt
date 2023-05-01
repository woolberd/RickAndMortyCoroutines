package com.example.rickandmortycorutines.ui.fragments


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycorutines.data.repository.CharacterRepository
import com.example.rickandmortycorutines.data.repository.LocationRepository
import com.example.rickandmortycorutines.models.CharacterAndLocationModel
import com.example.rickandmortycorutines.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _noteLiveData = MutableLiveData<Resource<CharacterAndLocationModel>>()
    val noteLiveData: LiveData<Resource<CharacterAndLocationModel>> = _noteLiveData

    fun getData() {
        val character = viewModelScope.async {
            characterRepository.fetchCharacter()
        }
        val location = viewModelScope.async {
            locationRepository.fetchLocation()
        }
        viewModelScope.launch {
            character.await().combine(location.await()) { character, location ->
                return@combine when {
                    character is Resource.Success<*> && location is Resource.Success<*> -> {
                        Resource.Success(
                            character.results.get(0).id.plus(location.results.get(0).id)
                        )
                    }
                    character is Resource.Error<*> && location is Resource.Error<*> -> {
                        Resource.Error(character.message.toString() + location.message.toString())
                    }
                    else -> {
                        Resource.Loading()
                    }
                }
            }.collect{
                _noteLiveData.postValue(it)
            }
        }
    }
}


