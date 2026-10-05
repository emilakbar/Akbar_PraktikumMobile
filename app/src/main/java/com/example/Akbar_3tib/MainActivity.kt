package com.example.Akbar_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Akbar_3tib.databinding.ActivityMainBinding
import com.example.Akbar_3tib.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Mengambil data dari LoginActivity
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")
        val umur = intent.getIntExtra("umur", 0)

        Log.d("Output", "Username: $user")
        Log.d("Output", "Password: $pass")
        Log.d("Output", "Umur: $umur")

        // Menampilkan username dan password
        binding.txtUsername.text = user ?: "Username"
        binding.txtPassword.text = pass ?: "Password"

        // Snack Bar
        binding.btnSnackBar.setOnClickListener {

            Snackbar.make(
                binding.root,
                "Item dihapus",
                Snackbar.LENGTH_LONG
            )
                .setAction("BATAL") {
                    Snackbar.make(
                        binding.root,
                        "Penghapusan dibatalkan",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                .show()
        }

        // Alert Dialog
        binding.btnAlert.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus Data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->

                    dialog.dismiss()

                    Snackbar.make(
                        binding.root,
                        "Data berhasil dihapus",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                .setCancelable(false)
                .show()
        }

        // Tombol Kembali
        binding.btnKembali.setOnClickListener {
            finish()
        }

        // Tombol Pertemuan 5
        binding.btnToLima.setOnClickListener {

            Log.d("MainActivity", "Tombol Pertemuan 5 ditekan")

            val intent = Intent(
                this@MainActivity,
                LimaActivity::class.java
            )

            startActivity(intent)
        }
    }
}