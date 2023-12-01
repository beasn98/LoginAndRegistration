package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    //methodName_someCondition_expectedResult
    @Test
    fun validatePassword_emptyPassword_isFalse() {
        val actual = RegistrationUtil.validatePassword("","")
        //assertThat(actualValue).isEqual(desiredValue)
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_isFalse() {
        val actual = RegistrationUtil.validatePassword("A1bcdefgh", "1Abcdefgh")
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_passwordNoCapital_isFalse() {
        val actual = RegistrationUtil.validatePassword("gsdhkfjah1", "gsdhkfjah1")
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_passwordNoDigit_isFalse() {
        val actual = RegistrationUtil.validatePassword("Fskuydafglhwjd", "Fskuydafglhwjd")
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_notEight_isFalse() {
        val actual = RegistrationUtil.validatePassword("asdB8","asdB8")
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_passAllCases_isTrue() {
        val actual = RegistrationUtil.validatePassword("sakhjdBsalidh1s", "sakhjdBsalidh1s")
        assertThat(actual).isTrue()
    }

    //end of validate password

    @Test
    fun validateUsername_alreadyTaken_isFalse() {
        val actual = RegistrationUtil.validateUsername("beasn")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateUsername_not3Long_isFalse() {
        val actual = RegistrationUtil.validateUsername("hi")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateUsername_emptyUsername_isFalse() {
        val actual = RegistrationUtil.validateUsername("")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateName_emptyName_isFalse() {
        val actual = RegistrationUtil.validateName("")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateName_actualName_isTrue() {
        val actual = RegistrationUtil.validateName("billy")
        assertThat(actual).isTrue()
    }

    @Test
    fun validateEmail_validEmail_isTrue() {
        val actual = RegistrationUtil.validateEmail("leafAsk@gmail.com")
        assertThat(actual).isTrue()
    }

    @Test
    fun validateEmail_missingDomain_isFalse() {
        val actual = RegistrationUtil.validateEmail("leafAsked@.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_missingPeriod_isFalse() {
        val actual = RegistrationUtil.validateEmail("leaf.Asked@gmailcom")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_missingAddress_isFalse() {
        val actual = RegistrationUtil.validateEmail("@gmail.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_extraPeriod_isTrue() {
        val actual = RegistrationUtil.validateEmail("leaf.Asked@.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_missingAt_isFalse() {
        val actual = RegistrationUtil.validateEmail("leafAsked.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_alreadyTaken_isFalse() {
        val actual = RegistrationUtil.validateEmail("bigGuy@gmail.com")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_missingEnd_isFalse() {
        val actual = RegistrationUtil.validateEmail("leafAsked@gmail.")
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_isEmpty_isFalse() {
        val actual = RegistrationUtil.validateEmail("")
        assertThat(actual).isFalse()
    }



    //Make tests for failures of
        //min length of 8 chars
        //at least one digit (make sure its at least 8 and has a capital letter)
        //at least one capital letter
    //make a test for good passwords matching working

    //make tests for the other functions in the Util class
    //the common failures and and 1 success for each

    //When done with all unit tests and they are successful, implement the validation in your RegistrationActivity.
    //It should not register anything if anything is not valid
}