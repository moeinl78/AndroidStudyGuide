package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.extensions.toArticle
import com.example.androidstudyguide.utils.wrapper.DataResponse

/**
 * This networking service will request [Article] entities from the Remote Repository.
 */
class EssenceArticleRepository(
    private val api: EssenceAPI
) : ArticleRepository {
    override suspend fun getArticles(): DataResponse<List<Article>> {
        return try {
            val res = api.getFeed().items?.map { it.toArticle() }.orEmpty()
            DataResponse.Success(res)
        } catch (error: Throwable) {
            DataResponse.Error(error)
        }
    }
}
