package com.example.fiapp.di

import com.example.fiapp.data.UserClient
import com.example.fiapp.domain.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModuleInjection {

    @Singleton
    @Provides
    fun provideUserClient(): UserClient {
        return UserClient()
    }

    @Singleton
    @Provides
    fun provideUserRepository(userClient: UserClient): UserRepository {
        return UserRepository(userClient)
    }
}