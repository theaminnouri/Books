package com.theaminnouri.data_remote.networking.api

import com.theaminnouri.data_remote.networking.model.Volume
import com.theaminnouri.data_remote.networking.model.Volumes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VolumesApiService {

    @GET("/v1/volumes")
    suspend fun getVolumes(@Query("q") query: String): Volumes

    @GET("/v1/volumes/{id}")
    suspend fun getVolume(@Path("id") id: String): Volume
}
