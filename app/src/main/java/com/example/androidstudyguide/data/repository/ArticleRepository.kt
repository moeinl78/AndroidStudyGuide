package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.models.Articles

interface ArticleRepository {
    suspend fun getArticles(): List<Articles>
}
