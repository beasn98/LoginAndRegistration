package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity: AppCompatActivity() {

    private lateinit var binding : ActivityRegistrationBinding
    override fun onCreate(savedInstanceBundle: Bundle?) {
        super.onCreate(savedInstanceBundle)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //retrieve any information from the Intent using the EXTRAs keys
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME) ?: ""
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD) ?: ""

        //prefill the username and password fields
        //for editTexts, you have to use the setText functions
        binding.editTextRegistrationUsername.setText(username)
        binding.editTextPasswordRegistrationPassword.setText(password)

        //register an account and send back the username and password to the login activity to prefill those fields
        binding.buttonRegistrationRegister.setOnClickListener {
            val password = binding.editTextPasswordRegistrationPassword.text.toString()
            val confirm = binding.editTextPasswordRegistrationConfirmPassword.text.toString()
            val username = binding.editTextRegistrationUsername.text.toString()
            val email = binding.editTextEmailAddressRegistrationEmail.text.toString()
            val name = binding.editTextRegistrationName.text.toString()

            if (RegistrationUtil.validatePassword(password, confirm) &&
                RegistrationUtil.validateUsername(username) &&
                RegistrationUtil.validateEmail(email) &&
                RegistrationUtil.validateName(name)) {
                //apply lambda will call the functions inside it on the object that apply is called on
                val resultIntent = Intent().apply {
                    // apply { putExtra() } is doing the same thing as resultIntent.putExtra()
                    putExtra(LoginActivity.EXTRA_USERNAME, binding.editTextRegistrationUsername.text.toString())
                    putExtra(LoginActivity.EXTRA_PASSWORD, password)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            else {
                Toast.makeText(this, "Please fill out the fields correctly", Toast.LENGTH_SHORT).show()
            }


        }
    }


}