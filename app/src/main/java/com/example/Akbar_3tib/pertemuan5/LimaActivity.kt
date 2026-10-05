package com.example.Akbar_3tib.pertemuan5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Akbar_3tib.R
import com.google.android.material.appbar.MaterialToolbar

class LimaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lima)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        val btnWebView = findViewById<Button>(R.id.btnWebView)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Halaman Pertemuan 5"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Tombol WebView di halaman
        btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.menu_search -> {
                Toast.makeText(
                    this,
                    "Search Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.menu_setting -> {
                Toast.makeText(
                    this,
                    "Setting Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.menu_profile -> {
                Toast.makeText(
                    this,
                    "Profile Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}