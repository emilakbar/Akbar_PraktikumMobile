package com.example.Akbar_3tib.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.Akbar_3tib.R

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val rowView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_message, parent, false)

        val avatar = rowView.findViewById<ImageView>(R.id.avatarImg)
        val sender = rowView.findViewById<TextView>(R.id.textSender)
        val message = rowView.findViewById<TextView>(R.id.textMessage)
        val time = rowView.findViewById<TextView>(R.id.textTime)

        val item = messages[position]

        sender.text = item.senderName
        message.text = item.messageText
        time.text = item.messageTime

        Glide.with(context)
            .load(item.avatarUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .circleCrop()
            .into(avatar)

        return rowView
    }
}
