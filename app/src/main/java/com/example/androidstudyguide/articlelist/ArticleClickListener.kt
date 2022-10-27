package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.models.Article

interface ArticleClickListener {
    fun onArticleClicked(article: Article)
    fun onArticleBookmarkClicked(article: Article)
}
