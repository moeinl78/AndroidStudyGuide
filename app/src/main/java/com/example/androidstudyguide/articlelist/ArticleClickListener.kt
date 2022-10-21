package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.models.Articles

interface ArticleClickListener {
    fun onArticleClicked(article: Articles)
}
