package com.uzdev.guidebook.api

import com.uzdev.guidebook.model.GuideData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/service/v2/upcomingGuides/")
    fun getData(): Call<GuideData>
}