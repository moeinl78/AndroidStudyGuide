package com.example.androidstudyguide.utils.wrapper

sealed class DataResponse<T> {
    data class Success<T>(val data: T) : DataResponse<T>()
    data class Error<T>(val error: Throwable) : DataResponse<T>()
}
