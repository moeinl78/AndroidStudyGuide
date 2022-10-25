package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.utils.wrapper.DataResponse
import com.example.androidstudyguide.utils.wrapper.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState>
        get() = _state

    init {
        _state.postValue(ViewState.Loading)
        viewModelScope.launch(Dispatchers.IO) {

            val response = articleRepository.getArticles()
            _state.value = when (response) {
                is DataResponse.Success -> ViewState.Success(response.data)
                is DataResponse.Error -> ViewState.Error(response.error)
            }
        }
    }
}
