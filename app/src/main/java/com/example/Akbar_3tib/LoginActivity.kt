
package com.example.Akbar_3tib

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Akbar_3tib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memeriksa apakah pengguna sudah login
        val preferences = getSharedPreferences(
            "LoginSession",
            MODE_PRIVATE
        )

        val isLoggedIn = preferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val username = preferences.getString("username", "admin")

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            finish()
            return
        }

        binding.btnLogin.setOnClickListener {
            val inputUsername =
                binding.edtUsername.text.toString().trim()

            val inputPassword =
                binding.edtPassword.text.toString()

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(
                    this,
                    "Username dan password wajib diisi!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (inputUsername == "admin" && inputPassword == "12345") {

                // Menyimpan status login
                preferences.edit()
                    .putBoolean("isLoggedIn", true)
                    .putString("username", inputUsername)
                    .apply()

                Toast.makeText(
                    this,
                    "Login berhasil!",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", inputUsername)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(
                    this,
                    "Username atau password salah!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
