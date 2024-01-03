package com.theaminnouri.domain.usecase

import com.theaminnouri.domain.entity.Result
import com.theaminnouri.domain.entity.UseCaseException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

abstract class UseCase<I : UseCase.Request, O : UseCase.Response>(private val configuration: Configuration) {

    fun execute(request: I) = process(request = request)
        .map { response ->
            Result.Success(response) as Result<O>
        }
        .flowOn(context = configuration.dispatcher)
        .catch { throwable ->
            emit(Result.Error(UseCaseException.createFromThrowable(throwable)))
        }

    internal abstract fun process(request: I): Flow<O>
    class Configuration(val dispatcher: CoroutineDispatcher)

    interface Request

    interface Response

}