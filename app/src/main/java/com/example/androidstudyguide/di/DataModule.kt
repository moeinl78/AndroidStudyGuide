package com.example.androidstudyguide.di

import com.example.androidstudyguide.articlelist.EssenceArticleRepository
import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.repository.ArticleRepository
import com.example.androidstudyguide.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

val dataModule = module {

    single<EssenceAPI> {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val client = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(EssenceAPI::class.java)
    }

    factory<ArticleRepository> {
        EssenceArticleRepository(api = get())
    }
}
