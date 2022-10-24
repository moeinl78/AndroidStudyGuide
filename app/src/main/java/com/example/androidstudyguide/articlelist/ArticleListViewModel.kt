package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.extensions.toArticle
import com.example.androidstudyguide.utils.wrapper.Resources
import kotlinx.coroutines.Dispatchers
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
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val getArticles = articleRepository.getArticles()
                val res = Resources.Success(getArticles)
                _articles.postValue(res)
            } catch (ioException: IOException) {
                _articles.postValue(Resources.Error("Please check your network connection!"))
            }
        }
    }
}
