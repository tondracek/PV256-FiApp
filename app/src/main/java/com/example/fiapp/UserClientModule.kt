package com.example.fiapp

import UserClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserClientModule {
    @Provides
    fun provideUserClient(): UserClient {
        return UserClient()
    }
}