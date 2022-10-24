package com.example.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.utils.wrapper.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState>
        get() = _state

    init {
        _state.postValue(ViewState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val getArticles = articleRepository.getArticles()
                val res = ViewState.Success(getArticles)
                _state.postValue(res)
            } catch (ioException: IOException) {
                _state.postValue(ViewState.Error(error = Throwable("Please check your network connection!")))
            }
        }
    }
}
