package com.example.androidstudyguide.models

import com.example.androidstudyguide.utils.EncodeString

data class Articles(
    val title: EncodeString,
    val authorName: String,
    val url: String
)
