package com.example.androidstudyguide.articlelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.EncodeString
import com.example.androidstudyguide.utils.wrapper.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticleListViewModelTest {

    private val testRobot = ArticleListViewModelTestRobot()

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

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

    @Test
    fun retryAfterFailure() {
        val networkFailure = Throwable("Network Error!")
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
            .emitFailure(networkFailure)
            .assertViewState(
                expectedViewState = ViewState.Error(networkFailure)
            )
            .retryFetch()
            .assertViewState(
                expectedViewState = ViewState.Loading
            )
            .emitArticles(testArticles)
            .assertViewState(
                expectedViewState = ViewState.Success(testArticles)
            )
    }

    @Test
    fun bookmarkArticle() {
        val article = Article(
            title = EncodeString("Testing title")
        )

        val bookmarkedArticle = article.copy(bookmarked = true)

        testRobot
            .buildViewModel()
            .assertViewState(
                expectedViewState = ViewState.Loading
            )
            .emitArticles(listOf(article))
            .assertViewState(
                expectedViewState = ViewState.Success(listOf(article))
            )
            .bookmarkClicked(
                article
            )
            .assertViewState(
                expectedViewState = ViewState.Success(listOf(bookmarkedArticle))
            )
    }
}
