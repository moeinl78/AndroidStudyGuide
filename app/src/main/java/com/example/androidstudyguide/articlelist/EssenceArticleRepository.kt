package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.extensions.toArticle

class EssenceArticleRepository(
    private val api: EssenceAPI
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return api.getFeed().items?.map { it.toArticle() }.orEmpty()
    }
}
