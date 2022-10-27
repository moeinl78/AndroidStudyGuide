package com.example.androidstudyguide.utils

import android.text.Spanned
import androidx.core.text.HtmlCompat

/**
 * This is an inline class that is a helper to convert some [input] String to [Spanned] that can
 * render some HTML to the UI.
 */
inline class EncodeString(private val input: String) {
    fun getEncodedString(): Spanned {
        return HtmlCompat.fromHtml(input, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
