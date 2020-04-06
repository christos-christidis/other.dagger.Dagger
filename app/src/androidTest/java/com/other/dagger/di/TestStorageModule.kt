package com.other.dagger.di

import com.other.dagger.storage.FakeStorage
import com.other.dagger.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class TestStorageModule {

    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}