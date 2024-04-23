package com.example.fiapp.lala

import UserClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class UserClientModule {

    @Provides
    fun provideUserClient(
    ): UserClient {
        return UserClient()
    }
}