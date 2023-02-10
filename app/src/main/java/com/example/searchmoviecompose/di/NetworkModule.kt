package com.example.searchmoviecompose.di

import com.example.searchmoviecompose.network.NaverService
import com.example.searchmoviecompose.network.RetrofitNaverNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    @Provides
    @Singleton
    fun provideNaverService(): NaverService =
        RetrofitNaverNetwork()


}


