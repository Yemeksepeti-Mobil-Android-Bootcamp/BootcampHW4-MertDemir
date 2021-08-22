package com.example.bootcamphw4_mertdemr.di

import android.content.Context
import com.example.bootcamphw4_mertdemr.data.local.LocaleDataSource
import com.example.bootcamphw4_mertdemr.data.local.SharedPrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityRetainedComponent::class)
class DatabaseModule {

    @Provides
    fun sharedPrefManager(@ApplicationContext context: Context): SharedPrefManager {
        return SharedPrefManager(context)
    }

    @Provides
    fun localDataSource(sharedPrefManager: SharedPrefManager): LocaleDataSource {
        return LocaleDataSource(sharedPrefManager)
    }
}
