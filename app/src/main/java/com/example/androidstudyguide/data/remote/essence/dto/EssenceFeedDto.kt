package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Need to annotate use sites
 */
@Root(name = "feed", strict = false)
data class EssenceFeedDto(
    @field:ElementList(name = "entry", inline = true)
    @param:ElementList(name = "entry", inline = true)
    val items: List<EssenceFeedItemDto>
)