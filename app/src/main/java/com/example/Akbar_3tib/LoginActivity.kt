package com.example.Akbar_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Akbar_3tib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val btnLogin : Button = findViewById(R.id.btn_login)
//        val username : EditText = findViewById(R.id.edtUsername)
//        val password : EditText = findViewById(R.id.edtPassword)

        binding.btnLogin.setOnClickListener {
            val inputedUsername = binding.edtUsername.text.toString()
            val inputedPassword = binding.edtPassword.text.toString()
            Log.d("Output", "Username: $inputedUsername Password: $inputedPassword")

            Toast.makeText(this, "Username: $inputedUsername Password: $inputedPassword", Toast.LENGTH_LONG).show()

            val intent = Intent (this, MainActivity::class.java)
            intent.putExtra("username", inputedUsername )
            intent.putExtra("password", inputedPassword)
            intent.putExtra("umur", 20 )
            startActivity(intent)
        }
    }
}