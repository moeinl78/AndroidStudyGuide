package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedDto
import com.example.androidstudyguide.models.Article
import retrofit2.Response

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}
