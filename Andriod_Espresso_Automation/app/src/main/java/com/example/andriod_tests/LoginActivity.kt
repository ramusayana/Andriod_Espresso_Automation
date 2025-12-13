package com.example.andriod_tests

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val resultTextView = findViewById<TextView>(R.id.result_message)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty()) {
                resultTextView.text = "Username cannot be empty"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                resultTextView.text = "Password cannot be empty"
                return@setOnClickListener
            }
            
            if (username == "testuser" && password == "Password123") {
                 resultTextView.text = "Welcome!"
            }
        }
    }
}