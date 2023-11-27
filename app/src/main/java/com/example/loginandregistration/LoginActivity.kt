package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        //values to send Intents are called Extras and have the EXTRA_BLAH format
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent to do whatever we need with the returned info
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextPasswordLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
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
            registrationIntent.putExtra(EXTRA_USERNAME, binding.editTextLoginUsername.text.toString())
            registrationIntent.putExtra(EXTRA_PASSWORD, binding.editTextPasswordLoginPassword.text.toString())
            //launch the new activity using the intent
            //startActivity(registrationIntent)
            // Launch the activity for a result using the variable from the register for result contract above
            startRegistrationForResult.launch(registrationIntent)
        }
    }
}