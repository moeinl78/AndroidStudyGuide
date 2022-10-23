package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "feed", strict = false)
data class EssenceFeedDto(
    @ElementList(name = "entry", inline = true)
    val items: List<EssenceFeedItemDto>
)