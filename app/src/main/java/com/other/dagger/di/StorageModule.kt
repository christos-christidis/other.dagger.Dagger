package com.other.dagger.di

import com.other.dagger.storage.SharedPreferencesStorage
import com.other.dagger.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage) : Storage
}