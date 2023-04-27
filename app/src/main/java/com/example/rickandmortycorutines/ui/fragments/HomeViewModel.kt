package com.example.rickandmortycorutines.ui.fragments


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycorutines.data.repository.CharacterRepository
import com.example.rickandmortycorutines.data.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchCharacter() = characterRepository.fetchCharacter()

    fun getData() {
        val character = viewModelScope.async {
            characterRepository.fetchCharacter()
        }
        val location = viewModelScope.async {
            locationRepository.fetchLocation()
        }
        viewModelScope.launch {
            character.await()
            location.await()
        }
    }
}