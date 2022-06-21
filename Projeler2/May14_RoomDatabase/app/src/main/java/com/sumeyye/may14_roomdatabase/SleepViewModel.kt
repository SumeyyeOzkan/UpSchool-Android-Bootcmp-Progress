package com.sumeyye.may14_roomdatabase

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class SleepViewModel(private val sleepRepository: SleepRepository): ViewModel(){
    val allNights: LiveData<List<SllepNight>?> = sleepRepository.allSleepNight.asLiveData()

    fun insert(sleepNight: SllepNight) = viewModelScope.launch {
        sleepRepository.insert(sleepNight)
    }

}

class SleepViewModelFactory(private val repository: SleepRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SleepViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}