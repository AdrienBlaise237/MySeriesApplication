package com.example.seriesapp.data.remote

import com.example.seriesapp.data.model.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("most-popular")
    suspend fun getPopularSeries(@Query("page") page: Int): SeriesResponse
}
