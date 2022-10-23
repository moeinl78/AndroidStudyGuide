package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedDto
import com.example.androidstudyguide.data.repository.ArticleRepository
import retrofit2.Response

class EssenceArticleRepository(
    private val api: EssenceAPI
) : ArticleRepository {
    override suspend fun getArticles(): Response<EssenceFeedDto> {
        return api.getFeed()
    }
}
