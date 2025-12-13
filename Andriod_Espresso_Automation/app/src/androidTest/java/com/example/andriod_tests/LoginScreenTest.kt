package com.example.andriod_tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.andriod_tests.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testSuccessfulLogin() {
        // Type username
        onView(withId(R.id.username))
            .perform(replaceText("testuser"), closeSoftKeyboard())

        // Type password
        onView(withId(R.id.password))
            .perform(replaceText("Password123"), closeSoftKeyboard())

        // Click login button
        onView(withId(R.id.login_button)).perform(click())

        // Verify success message
        onView(withId(R.id.result_message))
            .check(matches(withText("Welcome!")))
    }

    @Test
    fun testEmptyUsernameShowsError() {
        onView(withId(R.id.username))
            .perform(clearText())

        onView(withId(R.id.login_button))
            .perform(click())

        onView(withText("Username cannot be empty"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testEmptyPasswordShowsError() {
        onView(withId(R.id.username))
            .perform(replaceText("testuser"), closeSoftKeyboard())

        onView(withId(R.id.password))
            .perform(clearText())

        onView(withId(R.id.login_button))
            .perform(click())

        onView(withText("Password cannot be empty"))
            .check(matches(isDisplayed()))
    }
}