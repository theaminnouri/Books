package com.theaminnouri.data_remote.injection

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    fun provideConvertorFactory(moshi: Moshi): Factory = MoshiConverterFactory.create(moshi)

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        factory: Factory,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books")
            .client(okHttpClient)
            .addConverterFactory(factory)
            .build()
}
