package com.example.testhotel

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String? = null,
    val error: Throwable? = null
) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(errorMsg: String? = null, error: Throwable? = null): Resource<T> {
            return Resource(Status.ERROR, null, errorMsg, error)
        }

        fun <T> message(msg: String): Resource<T> {
            return Resource(Status.MESSAGE, null, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    MESSAGE,
    LOADING
}

