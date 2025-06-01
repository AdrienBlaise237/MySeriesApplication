package com.example.seriesapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seriesapp.data.model.Series
import com.example.seriesapp.repository.SeriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: SeriesRepository
) : ViewModel() {

    var series = mutableStateOf<List<Series>>(emptyList())
    var isLoading = mutableStateOf(false)
    private var page = 1

    init {
        loadSeries()
    }

    fun loadSeries() {
        if (isLoading.value) return  // Évite les appels multiples

        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = repository.getSeries(page)
                series.value += response.tvShows
                page++
            } catch (e: Exception) {
                // Log ou traitement d’erreur ici
            } finally {
                isLoading.value = false
            }
        }
    }

}
