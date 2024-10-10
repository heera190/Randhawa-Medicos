package com.example.randhawamedicos.api

sealed class MResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?): MResult<T>(data = data)
    class Loading(message: String?): MResult<String>(message = message)
    class Error<T>(data: T?, message: String): MResult<T>(data = data, message = message)

}