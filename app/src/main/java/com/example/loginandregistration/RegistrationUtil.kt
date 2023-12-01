package com.example.loginandregistration

import androidx.core.text.isDigitsOnly

object RegistrationUtil {
    // use this in the test class for the is username taken test
    // make another similar list for some taken emails
    var existingUsers = ArrayList<String>().apply {
        add("beasn")
        add("lethalBacon")
    }
    var existingEmails = ArrayList<String>().apply {
        add("bigGuy@gmail.com")
    }
//    you can use listOf<type>() instead of making the list & adding individually
//    List<String> blah = new ArrayList<String>();
//    blah.add("hi")
//    blah.add("hello")

    // isn't empty
    // isn't already taken
    // minimum number of characters is 3
    fun validateUsername(username: String) : Boolean {
        if (username.isNotBlank() && username.length >= 3 && !existingUsers.contains(username)) {
            return true
        }
        return false
    }

    // make sure meets security requirements (deprecated ones that are still used everywhere)
    // min length 8 chars
    // at least one digit
    // at least one capital letter
    // both passwords match
    // not empty
    fun validatePassword(password : String, confirmPassword: String) : Boolean {
        if (password.length >= 8 && password == confirmPassword && (password.count {it.isDigit()} > 0) && password.lowercase() != password) {
            return true
        }
        return false
    }

    // isn't empty
    fun validateName(name: String) : Boolean {
        return name.isNotEmpty()
    }

    // isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email: String) : Boolean {
        if (email.isNotEmpty() && !existingEmails.contains(email)) {
            if (email.contains(Regex("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+"))) {
                return true
            }
        }
        return false
    }

}