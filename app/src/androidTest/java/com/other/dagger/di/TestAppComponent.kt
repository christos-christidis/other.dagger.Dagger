package com.other.dagger.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestStorageModule::class, AppSubcomponents::class])
interface TestAppComponent : AppComponent