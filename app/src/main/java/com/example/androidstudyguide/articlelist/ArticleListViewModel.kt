package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.extensions.toArticle
import com.example.androidstudyguide.utils.wrapper.Resources
import kotlinx.coroutines.launch
import okio.IOException

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    private val _articles = MutableLiveData<Resources<List<Article>>>()

    val articles: LiveData<Resources<List<Article>>>
        get() = _articles

    init {
        _articles.postValue(Resources.Loading())
        viewModelScope.launch {
            val getArticles = articleRepository.getArticles()
            try {
                if (getArticles.isSuccessful) {
                    val res = Resources.Success(
                        getArticles.body()?.items?.map {
                            it.toArticle()
                        }
                    )
                    _articles.postValue(res)
                } else {
                    _articles.postValue(Resources.Error("Failed to fetch data from network!"))
                }
            } catch (ioException: IOException) {
                _articles.postValue(Resources.Error("Please check your network connection!"))
            }
        }
    }
}
