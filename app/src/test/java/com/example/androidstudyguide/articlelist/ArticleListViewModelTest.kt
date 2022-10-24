package com.example.androidstudyguide.articlelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidstudyguide.models.Article
import com.example.androidstudyguide.utils.EncodeString
import com.example.androidstudyguide.utils.wrapper.ViewState
import org.junit.Rule
import org.junit.Test

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
            .mockArticles(testArticles)
            .assertViewState(
                expectedViewState = ViewState.Loading
            )
    }
}
