package com.example.instadev.data.di

import com.example.instadev.data.repository.AuthRepositoryImpl
import com.example.instadev.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Provides
    fun provideAuthRepository(): AuthRepository {

        return AuthRepositoryImpl()
    }
}