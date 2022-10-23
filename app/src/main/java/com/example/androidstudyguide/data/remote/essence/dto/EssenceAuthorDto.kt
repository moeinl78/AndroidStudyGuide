package com.example.androidstudyguide.data.remote.essence.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "author", strict = false)
data class EssenceAuthorDto(
    @field:Element(name = "name")
    @param:Element(name = "name")
    val name: String = ""
)
