package com.example.androidstudyguide.data.remote.essence

import com.example.androidstudyguide.data.remote.essence.dto.EssenceFeedDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET

interface EssenceAPI {

    @GET("feed.xml")
    suspend fun getFeed(): EssenceFeedDto

    companion object {
        private const val BASE_URL = "https://androidessence.com/"

        fun getInstance(): EssenceAPI {
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
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(client)
                .build()
                .create(EssenceAPI::class.java)
        }
    }
}