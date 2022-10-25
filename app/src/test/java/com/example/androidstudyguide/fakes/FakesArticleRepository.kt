package com.example.androidstudyguide.fakes

import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.wrapper.DataResponse
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FakesArticleRepository : ArticleRepository {
    private var mockedArticles: List<Article> = emptyList()
    private lateinit var articleListContinuation: Continuation<DataResponse<List<Article>>>

    override suspend fun getArticles(): DataResponse<List<Article>> {
        return suspendCoroutine { continuation ->
            articleListContinuation = continuation
        }
    }

    fun emitArticles(articles: List<Article>) {
        val response = DataResponse.Success(articles)
        articleListContinuation.resume(response)
    }

    fun emitFailure(error: Throwable) {
        val response = DataResponse.Error<List<Article>>(error)
        articleListContinuation.resume(response)
    }
}
