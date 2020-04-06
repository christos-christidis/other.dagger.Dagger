package com.other.dagger

import com.other.dagger.di.AppComponent
import com.other.dagger.di.DaggerTestAppComponent

class MyTestApplication : MyApplication() {

    override fun initializeComponent(): AppComponent {
        return DaggerTestAppComponent.create()
    }
}
