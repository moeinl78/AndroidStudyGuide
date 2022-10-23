package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "link", strict = false)
data class EssenceLinkDto(

    @field:Attribute(name = "href")
    @param:Attribute(name = "href")
    val href: String = ""
)
