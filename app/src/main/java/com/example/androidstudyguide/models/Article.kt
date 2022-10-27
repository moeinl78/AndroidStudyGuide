package com.example.androidstudyguide.models

import com.example.androidstudyguide.utils.EncodeString

/**
 * An article is a text document that provides helpful learning resources for the reader.
 * @property[title] Some data sources for articles may include HTML characters, so we need the
 * [EncodeString] class to do the necessary decoding before displaying the text on the UI.
 * @property[authorName] This is the name of the person who wrote the article
 * @property[url] This is the web address for this article.
 * @property[bookmarked] if user saved an article or not.
 */
data class Article(
    val title: EncodeString,
    val authorName: String = "",
    val url: String = "",
    var bookmarked: Boolean = false
)
