package com.example.androidstudyguide.data.repository

import com.example.androidstudyguide.models.Articles

interface ArticleRepository {
    fun getArticles(): List<Articles>
}
