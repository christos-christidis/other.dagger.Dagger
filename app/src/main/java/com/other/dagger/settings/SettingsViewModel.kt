package com.other.dagger.settings

import com.other.dagger.user.UserDataRepository
import com.other.dagger.user.UserManager

/**
 * SettingsViewModel is the ViewModel that [SettingsActivity] uses to handle complex logic.
 */
class SettingsViewModel(
    private val userDataRepository: UserDataRepository, private val userManager: UserManager
) {

    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
}
