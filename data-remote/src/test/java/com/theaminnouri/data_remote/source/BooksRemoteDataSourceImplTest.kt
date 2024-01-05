package com.theaminnouri.data_remote.source

import com.theaminnouri.data_remote.networking.api.VolumesApiService
import com.theaminnouri.data_remote.networking.model.ImageLinks
import com.theaminnouri.data_remote.networking.model.Volume
import com.theaminnouri.data_remote.networking.model.VolumeInfo
import com.theaminnouri.data_remote.networking.model.Volumes
import com.theaminnouri.domain.entity.Book
import com.theaminnouri.domain.entity.UseCaseException
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class BooksRemoteDataSourceImplTest {
    private val volumesApiService = mock<VolumesApiService>()
    private val remoteDataSource = BooksRemoteDataSourceImpl(volumesApiService = volumesApiService)
    private val volume1 = Volume(
        id = "1",
        volumeInfo = VolumeInfo(
            title = "title1",
            authors = arrayListOf("author1"),
            publishedDate = "2024",
            imageLinks = ImageLinks(large = "image1")
        )
    )
    private val volume2 = Volume(
        id = "2",
        volumeInfo = VolumeInfo(
            title = "title2",
            authors = arrayListOf("author2"),
            publishedDate = "2023",
            imageLinks = ImageLinks(large = "image2")
        )
    )
    private val book1 = Book(
        id = "1",
        image = "image1",
        name = "title1",
        releaseData = "2024",
        author = "author1"
    )
    private val book2 = Book(
        id = "2",
        image = "image2",
        name = "title2",
        releaseData = "2023",
        author = "author2"
    )

    @Test
    fun testGetBooks(): Unit = runBlocking {

        val volumes = Volumes(items = arrayListOf(volume1, volume2))

        val books = listOf(
            book1,
            book2
        )

        whenever(volumesApiService.getVolumes(anyString())).thenReturn(volumes)

        val result = remoteDataSource.getBooks("any").first()
        assertEquals(books, result)
    }

    @Test
    fun testGetBook(): Unit = runBlocking {

        whenever(volumesApiService.getVolume(anyString())).thenReturn(volume1)

        val result = remoteDataSource.getBook("any").first()
        assertEquals(book1, result)
    }

    @Test
    fun testGetBooksThrowError(): Unit = runBlocking {
        whenever(volumesApiService.getVolumes(anyString())).thenThrow(RuntimeException())

        remoteDataSource.getBooks("any").catch {
            assertTrue(it is UseCaseException.BooksException)
        }.collect()
    }
    @Test
    fun testGetBookThrowError(): Unit = runBlocking {
        whenever(volumesApiService.getVolume(anyString())).thenThrow(RuntimeException())

        remoteDataSource.getBook("any").catch {
            assertTrue(it is UseCaseException.BookException)
        }.collect()
    }
}
