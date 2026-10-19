package com.example.Akbar_3tib

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Akbar_3tib.databinding.ActivityMainBinding
import com.example.Akbar_3tib.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data username dari LoginActivity
        val preferences = getSharedPreferences(
            "LoginSession",
            MODE_PRIVATE
        )

        val username = preferences.getString(
            "username",
            intent.getStringExtra("username") ?: "Username"
        )

        // Menampilkan username
        binding.txtUsername.text = "Username: $username"

        // Menampilkan status password tanpa menampilkan password asli
        binding.txtPassword.text = "Status: Berhasil login"

        // Tombol Snackbar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Item dihapus",
                Snackbar.LENGTH_LONG
            ).setAction("BATAL") {
                Snackbar.make(
                    binding.root,
                    "Penghapusan dibatalkan",
                    Snackbar.LENGTH_SHORT
                ).show()
            }.show()
        }

        // Tombol Alert Dialog
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus Data")
                .setMessage(
                    "Data yang dihapus tidak bisa dikembalikan."
                )
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

        // Tombol menuju Pertemuan 5
        binding.btnToLima.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                LimaActivity::class.java
            )
            startActivity(intent)
        }

        // Tombol Logout
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah kamu yakin ingin keluar?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Logout") { _, _ ->

                    // Menghapus sesi login
                    preferences.edit()
                        .clear()
                        .apply()

                    Toast.makeText(
                        this,
                        "Berhasil logout",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Kembali ke LoginActivity
                    val logoutIntent = Intent(
                        this@MainActivity,
                        LoginActivity::class.java
                    )

                    logoutIntent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(logoutIntent)
                    finish()
                }
                .show()
        }
    }
}
