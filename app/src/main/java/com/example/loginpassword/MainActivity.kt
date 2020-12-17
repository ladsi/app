package com.example.loginpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var signInButton: Button
    private lateinit var registrationButton: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser !=null) {
            startActivity(Intent(this, UserActivity::class.java))
            finish()

        }

        setContentView(R.layout.activity_main)

        inputEmail = findViewById(R.id.signInEmailText)
        inputPassword = findViewById(R.id.signInPasswordText)
        signInButton = findViewById(R.id.logInButton)
        registrationButton = findViewById(R.id.regiterButton)

        signInButton.setOnClickListener {

            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() or password.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, UserActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }

                    }
            }

        }

        registrationButton.setOnClickListener {
            startActivity(Intent(this, register::class.java))
        }

    }

}