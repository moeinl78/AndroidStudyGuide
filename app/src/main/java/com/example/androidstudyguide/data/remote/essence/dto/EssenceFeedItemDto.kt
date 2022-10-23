package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.Element

data class EssenceFeedItemDto(
    @Element(name = "title")
    val title: String ?= ""
)
