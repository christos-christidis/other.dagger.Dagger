package com.other.dagger

import android.app.Application
import com.other.dagger.di.AppComponent
import com.other.dagger.di.DaggerAppComponent

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}
