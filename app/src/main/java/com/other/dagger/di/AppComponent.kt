package com.other.dagger.di

import android.content.Context
import com.other.dagger.login.LoginComponent
import com.other.dagger.registration.RegistrationComponent
import com.other.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent() : LoginComponent.Factory
    fun userManager() : UserManager
}