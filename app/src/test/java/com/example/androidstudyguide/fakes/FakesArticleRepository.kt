package com.example.androidstudyguide.fakes

import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FakesArticleRepository : ArticleRepository {
    private var mockedArticles: List<Article> = emptyList()
    private lateinit var articleListContinuation: Continuation<List<Article>>

    override suspend fun getArticles(): List<Article> {
        return suspendCoroutine { continuation ->
            articleListContinuation = continuation
        }
    }

    fun emitArticles(articles: List<Article>) {
        articleListContinuation.resume(articles)
    }
}