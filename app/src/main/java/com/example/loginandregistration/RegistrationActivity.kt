package com.example.loginandregistration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity: AppCompatActivity() {

    private lateinit var binding:ActivityRegistrationBinding
    override fun onCreate(savedInstanceBundle: Bundle?) {
        super.onCreate(savedInstanceBundle)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //retrieve any information from the Intent using the EXTRAs keys
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME) ?: ""
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD) ?: ""

        //prefill the username and password fields
        //for editTexts, you have to use the setText functions
        binding.editTextTextRegistrationUsername.setText(username)
        binding.editTextTextPasswordRegistrationPassword.setText(password)

    }
}