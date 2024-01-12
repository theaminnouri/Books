package com.theaminnouri.presentation_common.state

import com.theaminnouri.domain.entity.Result

abstract class CommonResultConvertor<T : Any, R : Any> {
    fun convert(result: Result<T>): UiState<R> =
        when (result) {
            is Result.Error -> {
                UiState.Error(result.exception.localizedMessage.orEmpty())
            }

            is Result.Success -> {
                UiState.Success(convertSuccess(result.data))
            }
        }

    abstract fun convertSuccess(data: T): R
}
