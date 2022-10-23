package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "entry", strict = false)
data class EssenceFeedItemDto(

    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String = "",

    @field:Element(name = "id")
    @param:Element(name = "id")
    val url: String = "",

    @field:Element(name = "author")
    @param:Element(name = "author")
    val author: EssenceAuthorDto = EssenceAuthorDto(),

    @field:Element(name = "link")
    @param:Element(name = "link")
    val link: EssenceLinkDto = EssenceLinkDto()
)
