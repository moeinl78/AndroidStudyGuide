package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Articles

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    private val _articles = MutableLiveData<List<Articles>>()

    val articles: LiveData<List<Articles>>
        get() = _articles

    init {
        val getArticles = articleRepository.getArticles()
        _articles.postValue(getArticles)
    }
}