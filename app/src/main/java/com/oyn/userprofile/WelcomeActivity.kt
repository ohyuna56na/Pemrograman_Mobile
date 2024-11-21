package com.oyn.userprofile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewEligibility = findViewById<TextView>(R.id.textViewEligibility)

        val name = intent.getStringExtra("USER_NAME") ?: "Tidak diketahui"
        val age = intent.getIntExtra("USER_AGE", 0)
        val email = intent.getStringExtra("USER_EMAIL") ?: "Tidak diketahui"
        val eligibilityMessage = intent.getStringExtra("ELIGIBILITY_MESSAGE") ?: ""

        textViewGreeting.text = "Halo, $name! Selamat datang di aplikasi kami."
        textViewName.text = "Nama: $name"
        textViewAge.text = "Usia: $age"
        textViewEmail.text = "Email: $email"
        textViewEligibility.text = eligibilityMessage
    }
}
