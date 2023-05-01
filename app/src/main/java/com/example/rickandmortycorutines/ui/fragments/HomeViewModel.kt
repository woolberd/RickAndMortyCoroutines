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

    private val _noteLiveData =
        MutableLiveData<Resource<List<CharacterAndLocationModel>>>(Resource.Loading())
    val noteLiveData: LiveData<Resource<List<CharacterAndLocationModel>>> = _noteLiveData

    init {
        getData()
    }

    private fun getData() {
        val character = viewModelScope.async {
            characterRepository.fetchCharacter()
        }
        val location = viewModelScope.async {
            locationRepository.fetchLocation()
        }
        viewModelScope.launch {
            character.await().combine(location.await()) { character, location ->
                Pair(character, location)
            }.collect {
                when {
                    it.first is Resource.Error && it.second is Resource.Error -> {
                        _noteLiveData.value = Resource.Error(it.first.message + it.second.message)
                    }
                    it.first is Resource.Success && it.second is Resource.Success -> {
                        val modelsList = mutableListOf<CharacterAndLocationModel>()
                        it.first.data!!.results.zip(it.second.data!!.results).forEach { models ->
                            modelsList.add(
                                CharacterAndLocationModel(
                                    models.first,
                                    models.second,
                                    models.first.id
                                )
                            )
                        }
                        _noteLiveData.value = Resource.Success(modelsList)
                    }
                }
            }
        }
    }
}