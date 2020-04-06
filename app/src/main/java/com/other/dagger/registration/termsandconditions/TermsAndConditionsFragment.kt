package com.other.dagger.registration.termsandconditions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.other.dagger.R
import com.other.dagger.registration.RegistrationActivity
import com.other.dagger.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_terms_and_conditions.*
import javax.inject.Inject

class TermsAndConditionsFragment : Fragment() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as RegistrationActivity).registrationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next_button.setOnClickListener {
            registrationViewModel.acceptTCs()
            (activity as RegistrationActivity).onTermsAndConditionsAccepted()
        }
    }
}
