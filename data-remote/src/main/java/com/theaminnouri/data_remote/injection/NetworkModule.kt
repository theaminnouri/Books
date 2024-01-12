package com.theaminnouri.data_remote.injection

import com.google.gson.Gson
import com.theaminnouri.data_remote.networking.api.VolumesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    fun provideLogging(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    fun provideMoshi(): Gson = Gson()

    @Provides
    fun provideConvertorFactory(gson: Gson): Factory = GsonConverterFactory.create(gson)

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        factory: Factory,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/")
            .client(okHttpClient)
            .addConverterFactory(factory)
            .build()

    @Provides
    fun provideVolumesApiService(retrofit: Retrofit): VolumesApiService =
        retrofit.create(VolumesApiService::class.java)
}
