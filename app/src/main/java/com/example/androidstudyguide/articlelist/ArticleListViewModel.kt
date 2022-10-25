package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.utils.wrapper.DataResponse
import com.example.androidstudyguide.utils.wrapper.ViewState
import kotlinx.coroutines.launch

class ArticleListViewModel(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState>
        get() = _state

    init {
        fetchArticlesFromRepository()
    }

    fun retryFetch() {
        fetchArticlesFromRepository()
    }

    private fun fetchArticlesFromRepository() {
        viewModelScope.launch {
            _state.value = ViewState.Loading

            val response = articleRepository.getArticles()
            _state.value = when (response) {
                is DataResponse.Success -> ViewState.Success(response.data)
                is DataResponse.Error -> ViewState.Error(response.error)
            }
        }
    }
}
