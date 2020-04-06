package com.other.dagger.di

import com.other.dagger.login.LoginComponent
import com.other.dagger.registration.RegistrationComponent
import com.other.dagger.user.UserComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubcomponents