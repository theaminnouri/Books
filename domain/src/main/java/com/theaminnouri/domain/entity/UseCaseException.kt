package com.theaminnouri.domain.entity

sealed class UseCaseException(case: Throwable) : Throwable(case) {

    class BooksException(cause: Throwable) : UseCaseException(cause)
    class BookException(cause: Throwable) : UseCaseException(cause)

    companion object {

        class UnknownException(cause: Throwable) : UseCaseException(cause)

        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}