package com.example.bootcamphw4_mertdemr.di

import androidx.viewbinding.BuildConfig
import com.example.bootcamphw4_mertdemr.data.YemeksepetiApiRepository
import com.example.bootcamphw4_mertdemr.data.entity.common.Endpoint
import com.example.bootcamphw4_mertdemr.data.remote.RemoteDataSource
import com.example.bootcamphw4_mertdemr.data.remote.YemeksepetiApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NetworkYemeksepetiModule {


    @Provides
    fun provideTravelApiService(retrofit: Retrofit): YemeksepetiApiService{
        return retrofit.create(YemeksepetiApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        endPoint: Endpoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endPoint.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return builder.build()
    }

    @Provides
    fun provideEndpoint(): Endpoint {

        return Endpoint("http://yemeksepeti.baturhan.xyz/")
    }

   @Provides
    fun provideRemoteDataSource(
        apiService: YemeksepetiApiService,
    ): RemoteDataSource {
        return RemoteDataSource(apiService)
    }
}