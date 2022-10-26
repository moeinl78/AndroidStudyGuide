package com.example.androidstudyguide.di

import com.example.androidstudyguide.articlelist.EssenceArticleRepository
import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.repository.ArticleRepository

/**
 * Dependency graph to grab all of our dependencies related to requesting data for the application.
 */
interface DataGraph {
    val articleRepository: ArticleRepository
}

class NetworkDataGraph : DataGraph {
    override val articleRepository: ArticleRepository by lazy {
        EssenceArticleRepository(
            api = EssenceAPI.getInstance()
        )
    }
}
