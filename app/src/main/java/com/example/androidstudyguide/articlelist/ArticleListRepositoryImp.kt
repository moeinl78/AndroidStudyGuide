package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Articles

class ArticleListRepositoryImp : ArticleRepository {
    override fun getArticles(): List<Articles> {
        return listOf(
            Articles(
                title = "Dependency Injection",
                authorName = "Adam McNeilly",
                url = "https://medium.com/"
            ),
            Articles(
                title = "Lifecycle-aware Components",
                authorName = "Adam McNeilly",
                url = "https://medium.com/"
            ),
            Articles(
                title = "Retrofit and Network Calls",
                authorName = "Philip Lackner",
                url = "https://medium.com/"
            ),
            Articles(
                title = "Android Architecture",
                authorName = "Philip Lackner",
                url = "https://medium.com/"
            ),
            Articles(
                title = "Recycler View",
                authorName = "Moein Latifi",
                url = "https://medium.com/"
            ),
            Articles(
                title = "Reactive Programming",
                authorName = "Moein Latifi",
                url = "https://medium.com/"
            ),
        )
    }
}
