package com.example.cuentaganado.di

import com.example.cuentaganado.data.repository.CounterRepository
import com.example.cuentaganado.data.repository.CounterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CounterModule {

    @Binds
    @Singleton
    abstract fun provideCounterRepository(
        impl: CounterRepositoryImpl
    ): CounterRepository
}