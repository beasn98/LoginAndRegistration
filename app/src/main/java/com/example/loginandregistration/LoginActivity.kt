package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        //values to send Intents are called Extras and have the EXTRA_BLAH format
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewLoginSignUp.setOnClickListener{
            //create an intent object with the current activity and the destination activity's class
            val registrationIntent = Intent(this, RegistrationActivity::class.java)
            //optionally, add information to send with the intent
            //key-value pairs just like with bundles
            registrationIntent.putExtra(EXTRA_USERNAME, binding.editTextTextLoginUsername.text.toString())
            registrationIntent.putExtra(EXTRA_PASSWORD, binding.editTextTextPasswordLoginPassword.text.toString())
            //launch the new activity using the intent
            startActivity(registrationIntent)

        }

    }
}