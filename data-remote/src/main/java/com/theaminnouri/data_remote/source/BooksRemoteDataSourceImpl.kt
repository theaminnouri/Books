package com.theaminnouri.data_remote.source

import com.theaminnouri.data_remote.networking.api.VolumesApiService
import com.theaminnouri.data_remote.networking.model.Volume
import com.theaminnouri.data_repository.data_source.remote.BooksRemoteDataSource
import com.theaminnouri.domain.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class BooksRemoteDataSourceImpl(val volumesApiService: VolumesApiService) :
    BooksRemoteDataSource {
    override fun getBooks(query: String): Flow<List<Book>> = flow {
        val volumes = volumesApiService.getVolumes(query = query)
        val books = volumes.items.map { volume -> convert(volume) }
        emit(books)
    }

    override fun getBook(id: String): Flow<Book> = flow {
        val volume = volumesApiService.getVolume(id = id)
        val book = convert(volume)
        emit(book)
    }

    private fun convert(volume: Volume): Book =
        Book(
            id = volume.id ?: "",
            image = volume.volumeInfo?.imageLinks?.large ?: "",
            name = volume.volumeInfo?.title ?: "",
            author = volume.volumeInfo?.authors?.toString() ?: "",
            releaseData = volume.volumeInfo?.publishedDate ?: "",
        )

}
