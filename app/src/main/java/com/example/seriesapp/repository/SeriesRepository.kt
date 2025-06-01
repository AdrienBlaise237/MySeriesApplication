package com.example.seriesapp.repository

import com.example.seriesapp.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeriesRepository @Inject constructor(private val api: ApiService) {
    suspend fun getSeries(page: Int) = api.getPopularSeries(page)
}
