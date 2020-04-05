package com.other.dagger

import com.other.dagger.storage.FakeStorage
import com.other.dagger.user.UserManager

class MyTestApplication : MyApplication() {

    override val userManager by lazy {
        UserManager(FakeStorage())
    }
}
