package com.example.androidstudyguide.utils.wrapper

/**
 * This wrapper helps you to keep track of the different types we want to specify
 * for a https request.
 */
sealed class DataResponse<T> {
    data class Success<T>(val data: T) : DataResponse<T>()
    data class Error<T>(val error: Throwable) : DataResponse<T>()
}
