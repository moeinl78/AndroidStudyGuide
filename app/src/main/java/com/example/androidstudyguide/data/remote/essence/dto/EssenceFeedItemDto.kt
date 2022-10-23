package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.Element

data class EssenceFeedItemDto(

    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String = "",

    @field:Element(name = "id")
    @param:Element(name = "id")
    val url: String = "",

    @field:Element(name = "")
    @param:Element(name = "")
    val author: EssenceAuthorDto = EssenceAuthorDto()
)
