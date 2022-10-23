package com.example.androidstudyguide.utils.extensions

import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedItemDto
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.EncodeString

fun EssenceFeedItemDto.toArticle(): Article {
    return Article(
        title = EncodeString(this.title),
        authorName = this.author.name,
        url = this.link.href
    )
}
