package com.theaminnouri.books.injection

import com.theaminnouri.domain.repository.BooksRepository
import com.theaminnouri.domain.usecase.SearchUseCase
import com.theaminnouri.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideSearchUseCase(
        configuration: UseCase.Configuration,
        booksRepository: BooksRepository,
    ) = SearchUseCase(configuration = configuration, booksRepository = booksRepository)

}
