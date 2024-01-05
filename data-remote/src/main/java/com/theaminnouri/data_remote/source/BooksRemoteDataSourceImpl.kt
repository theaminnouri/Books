package com.theaminnouri.data_remote.source

import com.theaminnouri.data_remote.networking.api.VolumesApiService
import com.theaminnouri.data_remote.networking.model.Volume
import com.theaminnouri.data_remote.networking.model.Volumes
import com.theaminnouri.data_repository.data_source.remote.BooksRemoteDataSource
import com.theaminnouri.domain.entity.Book
import com.theaminnouri.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

data class BooksRemoteDataSourceImpl(val volumesApiService: VolumesApiService) :
    BooksRemoteDataSource {
    override fun getBooks(query: String): Flow<List<Book>> = flow {
        emit(volumesApiService.getVolumes(query = query))
    }.map { volumes: Volumes ->
        volumes.items.map { volume ->
            convert(volume)
        }
    }.catch {
        throw UseCaseException.BooksException(it)
    }

    override fun getBook(id: String): Flow<Book> = flow {
        emit(volumesApiService.getVolume(id = id))
    }.map { value ->
        convert(value)
    }.catch {
        throw UseCaseException.BookException(it)
    }

    private fun convert(volume: Volume): Book =
        Book(
            id = volume.id ?: "",
            image = volume.volumeInfo?.imageLinks?.large ?: "",
            name = volume.volumeInfo?.title ?: "",
            author = volume.volumeInfo?.authors?.reduce { acc, s -> "$acc, $s" } ?: "",
            releaseData = volume.volumeInfo?.publishedDate ?: "",
        )

}
