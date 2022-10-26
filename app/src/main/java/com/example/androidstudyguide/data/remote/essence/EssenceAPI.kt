package com.example.androidstudyguide.data.remote.essence

import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedDto
import retrofit2.http.GET

interface EssenceAPI {

    @GET("feed.xml")
    suspend fun getFeed(): EssenceFeedDto
}
