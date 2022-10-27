package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.wrapper.DataResponse

/**
 * This is a repository to fetch [Article] entities from remote or local repo's.
 */
interface ArticleRepository {
    suspend fun getArticles(): DataResponse<List<Article>>
}
