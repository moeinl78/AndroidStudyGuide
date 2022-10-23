package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedItemDto
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Articles
import com.example.androidstudyguide.utils.EncodeString

class EssenceArticleRepository(
    private val api: EssenceAPI
) : ArticleRepository {
    override suspend fun getArticles(): List<Articles> {
        return api.getFeed().items!!.map { it.toArticle() }
    }
}

private fun EssenceFeedItemDto.toArticle(): Articles {
    return Articles(
        title = EncodeString(this.title),
        authorName = this.author.name,
        url = this.link.href
    )
}
