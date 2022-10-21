package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Articles

class ArticleListRepositoryImp : ArticleRepository {
    override fun getArticles(): List<Articles> {
        return listOf(
            Articles(title = "Dependency Injection", authorName = "Adam McNeilly", url = ""),
            Articles(title = "Lifecycle-aware Components", authorName = "Adam McNeilly", url = ""),
            Articles(title = "Retrofit and Network Calls", authorName = "Philip Lackner", url = ""),
            Articles(title = "Android Architecture", authorName = "Philip Lackner", url = ""),
            Articles(title = "Recycler View", authorName = "Moein Latifi", url = ""),
            Articles(title = "Reactive Programming", authorName = "Moein Latifi", url = ""),
        )
    }
}
