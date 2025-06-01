package com.example.seriesapp.data.model

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    val total: Int,
    val page: Int,
    val pages: Int,
    @SerializedName("tv_shows")
    val tvShows: List<Series>
)

data class Series(
    val id: Int,
    val name: String,
    val permalink: String,
    @SerializedName("start_date") val startDate: String?,
    @SerializedName("end_date") val endDate: String?,
    val country: String?,
    val network: String?,
    val status: String?,
    @SerializedName("image_thumbnail_path") val imageThumbnailPath: String
)
