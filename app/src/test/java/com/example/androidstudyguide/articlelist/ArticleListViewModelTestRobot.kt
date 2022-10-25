package com.example.androidstudyguide.articlelist

import com.example.androidstudyguide.fakes.FakesArticleRepository
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.testObserver
import com.example.androidstudyguide.utils.wrapper.ViewState
import com.google.common.truth.Truth.assertThat

class ArticleListViewModelTestRobot {
    private lateinit var viewModel: ArticleListViewModel
    private val fakesArticleRepository = FakesArticleRepository()

    fun emitArticles(articles: List<Article>) = apply {
        fakesArticleRepository.emitArticles(articles)
    }

    fun emitFailure(error: Throwable) = apply {
        fakesArticleRepository.emitFailure(error)
    }

    fun buildViewModel() = apply {
        viewModel = ArticleListViewModel(
            articleRepository = fakesArticleRepository
        )
    }

    fun assertViewState(expectedViewState: ViewState) = apply {
        val actualViewState = viewModel.state.testObserver().observerdValue
        assertThat(actualViewState).isEqualTo(expectedViewState)
    }
}
