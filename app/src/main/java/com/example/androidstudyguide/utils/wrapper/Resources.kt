package com.example.androidstudyguide.utils.wrapper

sealed class Resources<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Resources<T>(data = data, message = null)
    class Error<T>(message: String?) : Resources<T>(data = null, message = message)
    class Loading<T> : Resources<T>()
}
