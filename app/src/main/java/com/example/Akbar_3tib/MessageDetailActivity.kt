package com.example.Akbar_3tib.Message

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.Akbar_3tib.R

class MessageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_detail)

        val avatar = findViewById<ImageView>(R.id.detailAvatar)
        val sender = findViewById<TextView>(R.id.detailSender)
        val message = findViewById<TextView>(R.id.detailMessage)
        val time = findViewById<TextView>(R.id.detailTime)

        val senderName = intent.getStringExtra("senderName") ?: "Pengirim"
        val messageText = intent.getStringExtra("messageText") ?: ""
        val avatarUrl = intent.getStringExtra("avatarUrl") ?: ""
        val messageTime = intent.getStringExtra("messageTime") ?: ""

        sender.text = senderName
        message.text = messageText
        time.text = "Waktu: $messageTime"

        Glide.with(this)
            .load(avatarUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .circleCrop()
            .into(avatar)

        supportActionBar?.title = "Detail Pesan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
