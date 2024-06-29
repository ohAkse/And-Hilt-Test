package com.example.hiltpractice.di

import com.example.hiltpractice.repositories.LocalRepository
import com.example.hiltpractice.repositories.LocalRepositoryImpl
import com.example.hiltpractice.services.FileService
import com.example.hiltpractice.services.FileServiceImpl
import com.example.hiltpractice.services.NetworkService
import com.example.hiltpractice.services.NetworkServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(impl: LocalRepositoryImpl): LocalRepository = impl
}

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideNetworkService(impl: NetworkServiceImpl): NetworkService = impl

    @Provides
    @Singleton
    fun provideFileService(impl: FileServiceImpl): FileService = impl
}

