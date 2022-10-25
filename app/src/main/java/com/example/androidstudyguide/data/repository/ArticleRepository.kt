package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.wrapper.DataResponse

interface ArticleRepository {
    suspend fun getArticles(): DataResponse<List<Article>>
}
