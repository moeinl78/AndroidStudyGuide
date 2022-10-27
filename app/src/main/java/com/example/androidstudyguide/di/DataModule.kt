package com.example.androidstudyguide.di

import com.example.androidstudyguide.articlelist.EssenceArticleRepository
import com.example.androidstudyguide.data.remote.essence.EssenceAPI
import com.example.androidstudyguide.data.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

/**
 * This is a Dagger-Hilt [Module] that defines how to create instances of any data
 * related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val BASE_URL = "https://androidessence.com/"

    @Provides
    fun essenceInstance(): EssenceAPI {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val client = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(EssenceAPI::class.java)
    }

    @Provides
    fun articleListRepository(): ArticleRepository {
        return EssenceArticleRepository(api = essenceInstance())
    }
}
