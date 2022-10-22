package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Articles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    private val _articles = MutableLiveData<List<Articles>>()

    val articles: LiveData<List<Articles>>
        get() = _articles

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val getArticles = articleRepository.getArticles()
            _articles.postValue(getArticles)
        }
    }
}
