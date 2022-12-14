package com.vkunitsyn.level2.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.databinding.ActivityAuthBinding
import com.vkunitsyn.level2.utils.Constants
import com.vkunitsyn.level2.utils.Parser
import com.vkunitsyn.level2.utils.Validator

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = applicationContext.getSharedPreferences(Constants.SHARED_PREFS_NAME, MODE_PRIVATE)

        fillInSavedData()
        controlPasswordInput()
        processRegisterButtonClick()
    }

    private fun fillInSavedData() {
        prefs = getPreferences(MODE_PRIVATE)
        binding.tietEmail.setText(prefs.getString(Constants.EMAIL, ""))
        binding.tietPassword.setText(prefs.getString(Constants.PASS, ""))
    }

    private fun processRegisterButtonClick() {
        binding.mbRegister.setOnClickListener() {
            checkEmail(binding.tietEmail.text.toString())
            checkIfPasswordIsEmpty()
            //Register button won't work if either e-mail or password layouts display errors
            if (noInputErrors()) {
                processSharedPreferences()
                val intent = Intent(this@AuthActivity, ProfileActivity::class.java)
                intent.putExtra(
                    Constants.USER_NAME,
                    Parser.parseEmail(binding.tietEmail.text.toString())
                )
                startActivity(intent)
            }
        }
    }

    //Displays error is the password is empty
    private fun checkIfPasswordIsEmpty() {
        if (binding.tietPassword.text.isNullOrEmpty()) {
            binding.tiloPassword.error = getString(R.string.pass_error_empty)
        }
    }

    //Checks if there are any errors in password or e-mail input layouts
    private fun noInputErrors(): Boolean {
        return binding.tiloPassword.error.isNullOrEmpty() && binding.tiloEmail.error.isNullOrEmpty()
    }

    //Saves or clears SharedPreferences depending on the "remember me" checkbox state.
    private fun processSharedPreferences() {
        with(prefs.edit()) {
            if (binding.cbRememberMe.isChecked) {
                putString(Constants.EMAIL, binding.tietEmail.text.toString())
                putString(Constants.PASS, binding.tietPassword.text.toString())
                apply()
            } else {
                clear()
                apply()
            }
        }
    }

    //Checks e-mail format
    private fun checkEmail(email: String) {
        binding.tiloEmail.error = ""
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tiloEmail.error = getString(R.string.email_error_format)
        }
    }


    /*Controls the process of password input. Displays errors in case the password doesn't meet
       certain criteria*/
    private fun controlPasswordInput() {
        binding.tietPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val password = p0.toString()
                with(binding.tiloPassword) {
                    when (Validator.validatePassword(password)) {
                        Constants.STRONG_PASS -> {
                            helperText = getString(R.string.pass_helperText_stongPass)
                            error = ""
                        }
                        Constants.WEAK_PASS -> error = getString(R.string.pass_error_weak)
                        Constants.SHORT_PASS -> error = getString(R.string.pass_error_short)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}