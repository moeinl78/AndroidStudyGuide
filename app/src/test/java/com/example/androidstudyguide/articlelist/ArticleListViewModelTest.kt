package com.example.androidstudyguide.articlelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.EncodeString
import com.example.androidstudyguide.utils.wrapper.ViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticleListViewModelTest {

    private val testRobot = ArticleListViewModelTestRobot()

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun successfulRequest() {
        val testArticles = listOf(
            Article(
                title = EncodeString("Testing title")
            )
        )

        testRobot
            .buildViewModel()
            .assertViewState(
                expectedViewState = ViewState.Loading
            )
            .emitArticles(testArticles)
            .assertViewState(
                expectedViewState = ViewState.Success(testArticles)
            )
    }

    @Test
    fun failureRequest() {
        val networkFailure = Throwable("Network Error!")

        testRobot
            .buildViewModel()
            .assertViewState(
                expectedViewState = ViewState.Loading
            )
            .emitFailure(networkFailure)
            .assertViewState(
                expectedViewState = ViewState.Error(networkFailure)
            )
    }
}
