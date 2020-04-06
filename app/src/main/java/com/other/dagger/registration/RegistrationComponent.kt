package com.other.dagger.registration

import com.other.dagger.di.ActivityScope
import com.other.dagger.registration.enterdetails.EnterDetailsFragment
import com.other.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
    fun inject(activity: EnterDetailsFragment)
    fun inject(activity: TermsAndConditionsFragment)
}