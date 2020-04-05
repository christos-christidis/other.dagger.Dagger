package com.other.dagger.registration.enterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.other.dagger.R
import com.other.dagger.registration.RegistrationActivity
import com.other.dagger.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_enter_details.*

class EnterDetailsFragment : Fragment() {

    /**
     * RegistrationViewModel is used to set the username and password information (attached to
     * Activity's lifecycle and shared between different fragments)
     * EnterDetailsViewModel is used to validate the user input (attached to this
     * Fragment's lifecycle)
     *
     * They could get combined but for the sake of the codelab, we're separating them so we have
     * different ViewModels with different lifecycles.
     */
    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var enterDetailsViewModel: EnterDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_enter_details, container, false)

        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        enterDetailsViewModel = EnterDetailsViewModel()
        enterDetailsViewModel.enterDetailsState.observe(this, Observer { state ->
            when (state) {
                is EnterDetailsSuccess -> {
                    val username = username_edittext.text.toString()
                    val password = password_edittext.text.toString()
                    registrationViewModel.updateUserData(username, password)

                    (activity as RegistrationActivity).onDetailsEntered()
                }
                is EnterDetailsError -> {
                    error_text.text = state.error
                    error_text.visibility = View.VISIBLE
                }
            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
    }

    private fun setupViews(view: View) {
        username_edittext.doOnTextChanged { _, _, _, _ -> error_text.visibility = View.INVISIBLE }
        password_edittext.doOnTextChanged { _, _, _, _ -> error_text.visibility = View.INVISIBLE }

        next_button.setOnClickListener {
            val username = username_edittext.text.toString()
            val password = password_edittext.text.toString()
            enterDetailsViewModel.validateInput(username, password)
        }
    }
}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()
