package com.oyn.userprofile

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val ageEditText = findViewById<EditText>(R.id.editTextAge)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val proceedButton = findViewById<Button>(R.id.buttonProceed)

        proceedButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val ageText = ageEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (ageText.isEmpty()) {
                Toast.makeText(this, "Umur tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null || age < 0) {
                Toast.makeText(this, "Masukkan umur yang valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(name, email, age)
            val eligibilityMessage = checkEligibility(name, age)

            val intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra("USER_NAME", user.name)
                putExtra("USER_AGE", user.age)
                putExtra("USER_EMAIL", user.email)
                putExtra("ELIGIBILITY_MESSAGE", eligibilityMessage)
            }
            startActivity(intent)
        }
    }

    private fun checkEligibility(name: String, age: Int): String {
        return if (age >= 18) {
            "Selamat, $name! Anda dapat menggunakan layanan kami."
        } else {
            "Maaf $name, Anda belum memenuhi syarat umur."
        }
    }
}
