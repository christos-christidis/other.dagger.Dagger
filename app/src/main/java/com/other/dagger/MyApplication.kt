package com.other.dagger

import android.app.Application
import com.other.dagger.storage.SharedPreferencesStorage
import com.other.dagger.user.UserManager

open class MyApplication : Application() {

    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}
