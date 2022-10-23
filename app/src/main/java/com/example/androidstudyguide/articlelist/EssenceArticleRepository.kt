package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedItemDto
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.EncodeString

class EssenceArticleRepository(
    private val api: EssenceAPI
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return api.getFeed().items!!.map { it.toArticle() }
    }
}

private fun EssenceFeedItemDto.toArticle(): Article {
    return Article(
        title = EncodeString(this.title),
        authorName = this.author.name,
        url = this.link.href
    )
}
