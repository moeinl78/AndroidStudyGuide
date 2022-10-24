package com.example.androidstudyguide.models

import com.example.androidstudyguide.utils.EncodeString

data class Article(
    val title: EncodeString,
    val authorName: String = "",
    val url: String = ""
)
