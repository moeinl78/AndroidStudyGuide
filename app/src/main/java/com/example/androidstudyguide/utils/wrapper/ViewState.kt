package com.example.androidstudyguide.utils.wrapper

import com.example.androidstudyguide.models.Article

/**
 * Use this wrapper to specify the state that the ui user should be in or
 * what state you need to show users in different situations.
 */
sealed class ViewState {
    data class Success(val articles: List<Article>) : ViewState()
    data class Error(val error: Throwable) : ViewState()
    object Loading : ViewState()
    object Empty : ViewState()
}
