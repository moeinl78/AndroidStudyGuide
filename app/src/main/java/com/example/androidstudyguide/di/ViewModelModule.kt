package com.example.androidstudyguide.di

import com.example.androidstudyguide.articlelist.ArticleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel<ArticleListViewModel> {
        ArticleListViewModel(articleRepository = get())
    }
}
