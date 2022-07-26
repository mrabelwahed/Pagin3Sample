package com.ramadan.task.core.di

import com.ramadan.task.data.RepositoryImpl
import com.ramadan.task.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: RepositoryImpl
    ): Repository
}