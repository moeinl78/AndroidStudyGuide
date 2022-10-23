package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedDto
import retrofit2.Response

interface ArticleRepository {
    suspend fun getArticles(): Response<EssenceFeedDto>
}
