package com.other.dagger.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.other.dagger.main.MainActivity
import com.other.dagger.MyApplication
import com.other.dagger.R
import com.other.dagger.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Creates ViewModel and listens for the loginState LiveData
        loginViewModel = LoginViewModel((application as MyApplication).userManager)
        loginViewModel.loginState.observe(this, Observer { state ->
            when (state) {
                is LoginSuccess -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                is LoginError -> error_text.visibility = View.VISIBLE
            }
        })

        setupViews()
    }

    private fun setupViews() {
        username_edittext.isEnabled = false
        username_edittext.setText(loginViewModel.getUsername())

        password_edittext.doOnTextChanged { _, _, _, _ -> error_text.visibility = View.INVISIBLE }

        login_button.setOnClickListener {
            loginViewModel.login(
                username_edittext.text.toString(), password_edittext.text.toString()
            )
        }
        unregister_button.setOnClickListener {
            loginViewModel.unregister()
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}

sealed class LoginViewState
object LoginSuccess : LoginViewState()
object LoginError : LoginViewState()
