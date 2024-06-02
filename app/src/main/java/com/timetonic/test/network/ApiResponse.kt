package com.timetonic.test.network

sealed class ApiResponse<T>(
    val data: T? = null,
    val throwable: Throwable? = null

) {
    class Success<T>(data: T?) : ApiResponse<T?>(data)
    class Error<T>(throwable: Throwable) : ApiResponse<T>(null, throwable)
}
