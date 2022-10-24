package com.example.androidstudyguide.utils.wrapper

import com.example.androidstudyguide.models.Article

sealed class ViewState {
    data class Success(val articles: List<Article>) : ViewState()
    data class Error(val error: Throwable) : ViewState()
    object Loading : ViewState()
    object Empty : ViewState()
}
