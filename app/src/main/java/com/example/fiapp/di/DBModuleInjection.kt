package com.example.fiapp.di

import com.example.fiapp.data.IUserClient
import com.example.fiapp.data.UserClient
import com.example.fiapp.domain.UserRepository
import com.example.fiapp.presentation.navigation.Navigator
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
    fun provideUserClient(): IUserClient {
        return UserClient()
    }

    @Singleton
    @Provides
    fun provideUserRepository(userClient: IUserClient): UserRepository {
        return UserRepository(userClient)
    }

    @Singleton
    @Provides
    fun provideNavigator(): Navigator {
        return Navigator()
    }
}