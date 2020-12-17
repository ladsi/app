package com.example.loginpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class UserActivity : AppCompatActivity() {

    private lateinit var userInfoTextView: TextView
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        mAuth = FirebaseAuth.getInstance()

        userInfoTextView = findViewById(R.id.userInfoTextView)
        logoutButton = findViewById(R.id.logOutButton)

        userInfoTextView.text = mAuth.currentUser?.uid

        logoutButton.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
            finish()
            mAuth.signOut()
        }
    }
}