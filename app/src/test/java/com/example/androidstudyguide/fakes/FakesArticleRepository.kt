package com.example.androidstudyguide.fakes

import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article

class FakesArticleRepository : ArticleRepository {
    private var mockedArticles: List<Article> = emptyList()

    override suspend fun getArticles(): List<Article> {
        return mockedArticles
    }

    fun setMockedArticles(articles: List<Article>) {
        this.mockedArticles = articles
    }
}