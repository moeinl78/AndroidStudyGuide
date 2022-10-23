package com.example.androidstudyguide.utils

import android.text.Spanned
import androidx.core.text.HtmlCompat

inline class EncodeString(private val input: String) {
    fun getEncodedString(): Spanned {
        return HtmlCompat.fromHtml(input, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
