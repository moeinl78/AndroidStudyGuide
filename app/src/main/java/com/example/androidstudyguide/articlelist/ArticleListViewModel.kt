package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.wrapper.DataResponse
import com.example.androidstudyguide.utils.wrapper.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * This class is responsible for requesting articles from the [articleRepository] and mapping
 * those requests into a [ViewState] which is then can be observerd through our [state] Livedata.
 */
@HiltViewModel
class ArticleListViewModel @Inject constructor(
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

    fun bookmarkClicked(article: Article) {
        // TODO implement the way bookmark icon supposed to work.
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
