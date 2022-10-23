package com.example.androidstudyguide.data.remote.essence

import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedItemDto
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Articles

class EssenceArticleService(
    private val api: EssenceAPI
) : ArticleRepository {
    override suspend fun getArticles(): List<Articles> {
        return api.getFeed().items.map { it.toArticle() }
    }
}

private fun EssenceFeedItemDto.toArticle(): Articles {
    return Articles(
        title = this.title,
        authorName = this.author.name,
        url = this.url
    )
}
