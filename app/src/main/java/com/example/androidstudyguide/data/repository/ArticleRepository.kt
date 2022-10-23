package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.models.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}
